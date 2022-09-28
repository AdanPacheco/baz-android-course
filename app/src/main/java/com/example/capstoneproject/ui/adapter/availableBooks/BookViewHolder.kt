package com.example.capstoneproject.ui.adapter.availableBooks

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.capstoneproject.R
import com.example.capstoneproject.data.model.availableBooks.AvailableBookModel
import com.example.capstoneproject.databinding.ItemBookBinding
import com.example.capstoneproject.domain.model.availableBook.AvailableBook
import com.example.capstoneproject.utils.Constants

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemBookBinding.bind(view)

    fun render(book: AvailableBook, onClickItem: (AvailableBook) -> Unit) {

        val coin = book.book.split('_')


        binding.apply {
            tvBookName.text = book.book
            tvMaximumPrice.text = itemView.context.getString(R.string.tv_maximum_price, book.maximum_price)

            Glide.with(binding.root.context)
                .load("${Constants.URL_CRIPTO_ICONS}${coin[0]}${Constants.EXT_CRIPTO_ICONS}")
                .placeholder(R.drawable.item_currency_placeholder)
                .error(R.drawable.item_book_error)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .transform(CenterCrop()).into(ivIcBook)
        }

        itemView.setOnClickListener {
            onClickItem(book)
        }
    }
}