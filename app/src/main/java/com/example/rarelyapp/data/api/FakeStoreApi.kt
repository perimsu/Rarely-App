package com.example.rarelyapp.data.api

import com.example.rarelyapp.data.model.Product
import retrofit2.http.GET

// 'FakeStoreApi' arayüzü, backend API ile etkileşime geçmek için kullanılacak.
// Bu interface, verilerin nasıl alınacağına dair sözleşmeyi belirtir.
interface FakeStoreApi {

    // Bu fonksiyon, 'products' endpoint'ine yapılacak GET isteğini temsil eder.
    // 'suspend' anahtar kelimesi, fonksiyonun bir coroutine içinde çağrılacağını belirtir, yani asenkron bir işlem olduğunu gösterir.
    @GET("products")
    // API'den alınacak ürün verilerini liste halinde döndüren bir fonksiyon.
    // Fonksiyon, API'den dönecek olan verilerin bir 'Product' listesi olduğunu belirtir.
    suspend fun getProducts(): List<Product>
}
