package com.example.liverpooltest.model

import com.example.liverpooltest.model.data.MainModel
import retrofit2.http.GET

interface ApiService {
    @GET("appclienteservices/services/v3/plp?search-string=%7B%7Bpredefinida%7D%7D&page-number=1")
    suspend fun getProducts(): MainModel
}