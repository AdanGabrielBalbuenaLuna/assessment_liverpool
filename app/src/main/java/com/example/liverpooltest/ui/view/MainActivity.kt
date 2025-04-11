package com.example.liverpooltest.ui.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liverpooltest.R
import com.example.liverpooltest.model.ProductRepository
import com.example.liverpooltest.ui.viewmodel.ProductViewModel
import com.example.liverpooltest.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = ProductRepository()
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(repository)
        )[ProductViewModel::class.java]

        adapter = ProductAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val searchField = findViewById<EditText>(R.id.searchInput)
        val button = findViewById<Button>(R.id.searchButton)
        val sortSpinner = findViewById<Spinner>(R.id.sortSpinner)

        button.setOnClickListener {
            val query = searchField.text.toString()
            val sortValue = getSortValue(sortSpinner.selectedItem.toString())
            viewModel.fetchProducts(query, sort = sortValue, reset = true)
        }

        viewModel.products.observe(this) { adapter.submitList(it.toList()) }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    val query = searchField.text.toString()
                    val sortValue = getSortValue(sortSpinner.selectedItem.toString())
                    viewModel.fetchProducts(query, sort = sortValue)
                }
            }
        })
    }

    private fun getSortValue(selection: String): String? = when (selection) {
        "Menor precio" -> "0"
        "Mayor precio" -> "1"
        else -> null
    }
}