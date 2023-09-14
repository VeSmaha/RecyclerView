package com.example.recyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val stringList = mutableListOf<StringItem>()
    private lateinit var adapter: StringAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val addButton: Button = findViewById(R.id.addButton)
        val editText: EditText = findViewById(R.id.editText)


        adapter = StringAdapter(stringList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isNotEmpty()) {
                val stringItem = StringItem(inputText)
                stringList.add(stringItem)
                adapter.notifyItemInserted(stringList.size - 1)
                editText.text.clear()
            }
        }
    }
}
