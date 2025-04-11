package com.example.liverpooltest.model.network

import com.example.liverpooltest.model.data.MainModel

class ProductRepository {
    suspend fun getProducts(query: String, page: Int, sort: String?): MainModel {
        val filters = mutableMapOf<String, String>()
        sort?.let { filters["minSortPrice|$it"] = "" }
        return RetrofitInstance.api.getProducts(query, page, filters)
    }
}