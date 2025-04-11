package com.example.liverpooltest.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    val api:ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://shoppapp.liverpool.com.mx/appclienteservices/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}