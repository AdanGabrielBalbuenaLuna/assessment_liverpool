package com.example.liverpooltest.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liverpooltest.databinding.ActivityMainBinding
import com.example.liverpooltest.model.network.ProductRepository
import com.example.liverpooltest.ui.viewmodel.ProductViewModel
import com.example.liverpooltest.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = ProductRepository()
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(repository)
        )[ProductViewModel::class.java]

        adapter = ProductAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.searchButton.setOnClickListener {
            val query = binding.searchInput.text.toString()
            val sortValue = getSortValue(binding.sortSpinner.selectedItem.toString())
            viewModel.fetchProducts(query, sort = sortValue, reset = true)
        }

        viewModel.products.observe(this) { adapter.submitList(it.toList()) }

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    val query = binding.searchInput.text.toString()
                    val sortValue = getSortValue(binding.sortSpinner.selectedItem.toString())
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