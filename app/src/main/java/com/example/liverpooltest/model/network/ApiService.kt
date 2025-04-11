package com.example.liverpooltest.model.network

import com.example.liverpooltest.model.data.MainModel
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface ApiService {
    @GET("appclienteservices/services/v3/plp")
    suspend fun getProducts(
        @Query("search-string") query: String,
        @Query("page-number") page: Int,
        @QueryMap filters: Map<String, String> = emptyMap()
    ): MainModel
}

//?search-string=%7B%7Bpredefinida%7D%7D&page-number=1