package com.example.hw_5644

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_5644.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ButtonClickListener, ItemDeleteListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        onButtonAdd()
    }

    private fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(this)
        binding.recyclerView.adapter = todoAdapter
    }

    private fun onButtonAdd() {
        binding.btnAdd.setOnClickListener {
            val text = binding.etTodo.text.toString()

            if (text == "") {
                Toast.makeText(this, getString(R.string.empty_et_toast), Toast.LENGTH_LONG).show()
            } else {
                val item = Todo(text)
                todoAdapter.setItems(item)
            }
        }
    }

    override fun onButtonClick(position: Int) {
        val args = Bundle()
        args.putInt("position", position)

        val confirmDialogFragment = ConfirmationDialogFragment(this)
        confirmDialogFragment.arguments = args

        val manager = supportFragmentManager
        confirmDialogFragment.show(manager, "confirmDialog")
    }

    override fun onItemDelete(position: Int) {
        todoAdapter.delete(position)
    }
}