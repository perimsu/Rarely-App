package com.example.rarelyapp.data.api

import com.example.rarelyapp.data.api.FakeStoreApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// RetrofitClient, API'ye bağlantıyı yöneten bir singleton nesnesidir.
// 'object' anahtar kelimesi, bu sınıfın yalnızca bir örneği olacağını garanti eder.
object RetrofitClient {

    // API'nin temel URL'sini belirtiyoruz. Bu URL, API ile yapılacak isteklerin temelini oluşturur.
    private const val BASE_URL = "https://api.escuelajs.co/api/v1/"

    // 'api' özelliği, FakeStoreApi arayüzünün bir örneğini oluşturur.
    // 'by lazy' kullanımı, bu özelliğin yalnızca ilk kez kullanıldığında başlatılmasını sağlar.
    val api: FakeStoreApi by lazy {
        // Retrofit.Builder() ile Retrofit nesnesini yapılandırıyoruz.
        Retrofit.Builder()
            // BASE_URL'i belirtiyoruz.
            .baseUrl(BASE_URL)
            // JSON verisini işlemek için GsonConverterFactory ekliyoruz.
            .addConverterFactory(GsonConverterFactory.create())
            // Retrofit nesnesini oluşturuyoruz ve ardından FakeStoreApi arayüzünü yaratıyoruz.
            .build()
            .create(FakeStoreApi::class.java) // FakeStoreApi arayüzünü yaratıyoruz.
    }
}