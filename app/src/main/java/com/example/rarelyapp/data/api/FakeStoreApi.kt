package com.example.rarelyapp.data.api

import com.example.rarelyapp.data.model.Product
import retrofit2.http.GET

interface FakeStoreApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
} 