package com.abdurashidov.roomreference.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdurashidov.roomreference.databinding.RvItemBinding
import com.abdurashidov.roomreference.db.MyCard


class RvAdapter(val list:ArrayList<MyCard>): RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val rvItem: RvItemBinding): RecyclerView.ViewHolder(rvItem.root){
        fun onBind(myCard: MyCard){
            rvItem.cardName.text=myCard.name
            rvItem.cardNumber.text=myCard.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}