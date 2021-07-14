package com.example.hw_5644

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val listener: ButtonClickListener): RecyclerView.Adapter<TodoViewHolder>() {

    private val todoList = arrayListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount() = todoList.count()


    fun setItems(newTodo: Todo) {
        todoList.add(newTodo)
        notifyDataSetChanged()
    }

    fun delete(position: Int){
        todoList.removeAt(position)
        notifyDataSetChanged()
    }
}