package com.abdurashidov.roomreference.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.abdurashidov.roomreference.R
import com.abdurashidov.roomreference.adapter.MyRvAdapter
import com.abdurashidov.roomreference.databinding.FragmentTransactionBinding
import com.abdurashidov.roomreference.db.AppDataBase
import com.abdurashidov.roomreference.db.MyCard
import com.abdurashidov.roomreference.db.MyTransaction


class TransactionFragment : Fragment() {

    private lateinit var binding: FragmentTransactionBinding
    private lateinit var appDataBase: AppDataBase
    private lateinit var cardList:ArrayList<MyCard>
    private lateinit var cardNameList:ArrayList<String>
    private lateinit var list:ArrayList<MyTransaction>
    private lateinit var myRvAdapter: MyRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appDataBase=AppDataBase.getInstance(requireContext())
        loadData()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentTransactionBinding.inflate(layoutInflater)
        binding.fromCard.adapter=ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1, cardNameList)
        binding.toCard.adapter=ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1, cardNameList)

        myRvAdapter=MyRvAdapter(list, appDataBase)
        binding.myRv.adapter=myRvAdapter

        binding.saveBtn.setOnClickListener {
            val myTransaction=MyTransaction(
                from_card_id = cardList[binding.fromCard.selectedItemPosition].id,
                to_card_id = cardList[binding.toCard.selectedItemPosition].id,
                summa = binding.summa.text.toString()
            )
            appDataBase.myDao().addTransaction(myTransaction)
            list.add(myTransaction)
            myRvAdapter.notifyDataSetChanged()
        }
        return binding.root
    }


    fun loadData(){
        cardList= ArrayList()
        cardNameList=ArrayList()
        cardList.addAll(appDataBase.myDao().getAllCards())
        cardList.forEach {
            cardNameList.add(it.name.toString())
        }

        list=ArrayList()
        list.addAll(appDataBase.myDao().getAllTransactions())
    }

}