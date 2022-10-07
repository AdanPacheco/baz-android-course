package com.example.capstoneproject.ui.adapter.availableBooks


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.capstoneproject.R
import com.example.capstoneproject.data.model.availableBooks.AvailableBookModel
import com.example.capstoneproject.domain.model.availableBook.AvailableBook

class AvailableBooksAdapter(private val onClickItem: (AvailableBook) -> Unit) : ListAdapter<AvailableBook, BookViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.render(book = getItem(position), onClickItem = onClickItem)

    }

    private object DiffUtilCallback : DiffUtil.ItemCallback<AvailableBook>() {
        override fun areItemsTheSame(oldItem: AvailableBook, newItem: AvailableBook): Boolean = oldItem.book == newItem.book
        override fun areContentsTheSame(oldItem: AvailableBook, newItem: AvailableBook): Boolean = oldItem == newItem

    }
}