package com.example.hw_5644

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_5644.databinding.ItemTodoViewholderBinding

class TodoViewHolder(val binding: ItemTodoViewholderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Todo) {
        binding.tvTodo.text = item.todo
    }

    companion object {
        fun create(parent: ViewGroup, listener: ButtonClickListener): TodoViewHolder {
            val binding = ItemTodoViewholderBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            val holder = TodoViewHolder(binding)

            holder.binding.btnDelete.setOnClickListener {
                val position: Int = holder.absoluteAdapterPosition
                listener.onButtonClick(position)
            }
            return holder
        }
    }
}