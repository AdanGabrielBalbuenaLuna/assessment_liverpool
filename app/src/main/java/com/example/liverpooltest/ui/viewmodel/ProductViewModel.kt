package com.example.liverpooltest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liverpooltest.Product
import com.example.liverpooltest.model.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    val products = MutableLiveData<List<Product>>()
    val error = MutableLiveData<String>()
    private var currentQuery = ""
    private var currentSort: String? = null
    private var currentPage = 1
    private val loadedProducts = mutableListOf<Product>()

    fun fetchProducts(query: String, sort: String? = null, reset: Boolean = false) {
        if (reset) {
            currentPage = 1
            loadedProducts.clear()
            currentQuery = query
            currentSort = sort
        }
        viewModelScope.launch {
            try {
                val response = repository.getProducts(currentQuery, currentPage, currentSort)
                val items = response.plpResults.records.map {
                    Product(
                        it.productDisplayName,
                        it.listPrice.toString(),
                        it.promoPrice.toString(),
                        it.lgImage,
                        it.variantsColor
                    )
                }
                loadedProducts.addAll(items)
                products.postValue(loadedProducts)
                currentPage++
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }
}
