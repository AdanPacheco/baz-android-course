package com.example.capstoneproject.ui.adapter.orderBook

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ItemOrderBookBinding
import com.example.capstoneproject.domain.model.orderBook.Ask
import com.example.capstoneproject.domain.model.orderBook.Bid

class OrderBookViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemOrderBookBinding.bind(view)

    fun render(item:Any){
        var price = ""
        var amount = ""

        when(item){
            is Bid -> {
                price = item.price
                amount = item.amount
            }
            is Ask -> {
                price = item.price
                amount = item.amount
            }
            else ->{}
        }

        binding.apply {
            tvOrderPrice.text = itemView.context.getString(R.string.tv_order_price,price)
            tvOrderAmount.text = itemView.context.getString(R.string.tv_order_amount,amount)
        }
    }


}
