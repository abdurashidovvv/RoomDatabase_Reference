package com.abdurashidov.roomreference.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdurashidov.roomreference.adapter.RvAdapter
import com.abdurashidov.roomreference.databinding.FragmentCardBinding
import com.abdurashidov.roomreference.db.AppDataBase
import com.abdurashidov.roomreference.db.MyCard

class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding
    private lateinit var appDataBase: AppDataBase
    private lateinit var rvAdapter: RvAdapter
    private lateinit var list:ArrayList<MyCard>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCardBinding.inflate(layoutInflater)
        appDataBase=AppDataBase.getInstance(binding.root.context)
        list= ArrayList()
        list.addAll(appDataBase.myDao().getAllCards())
        rvAdapter= RvAdapter(list)
        binding.myRv.adapter=rvAdapter

        binding.btnSave.setOnClickListener {
            val name=binding.name.text.toString()
            val number=binding.number.text.toString()
            if (name!="" && number!=""){
                val myCard=MyCard(
                    name = name,
                    number=number
                )
                appDataBase.myDao().addCard(myCard)
                list.add(myCard)
                rvAdapter.notifyDataSetChanged()
            }
        }

        return binding.root
    }
}