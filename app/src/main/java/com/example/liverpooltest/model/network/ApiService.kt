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