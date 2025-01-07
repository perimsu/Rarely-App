package com.example.rarelyapp.data.api

import com.example.rarelyapp.data.api.FakeStoreApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.escuelajs.co/api/v1/"

    val api: FakeStoreApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreApi::class.java)
    }
} 