package com.example.rarelyapp.data.model

// 'Product' verisi, API'den gelen her bir ürünün özelliklerini tutar.
// Bu veri sınıfı, ürünün tüm bilgilerini içerir ve API ile iletişimde kullanılır.
data class Product(
    // Ürünün benzersiz kimliği.
    val id: Int,
    // Ürünün adı veya başlığı.
    val title: String,
    // Ürünün fiyatı. Burada Integer olarak saklanıyor, ancak para birimi ve değer tipi durumlarına dikkat edilmelidir.
    val price: Int,
    // Ürünün açıklaması. Kullanıcıların ürünü daha iyi anlaması için detaylı açıklama.
    val description: String,
    // Ürüne ait bir veya birden fazla görselin URL'lerinin listesi.
    val images: List<String>,
    // Ürünün oluşturulma zamanı. API'den gelen tarih verisini temsil eder.
    val creationAt: String,
    // Ürünün güncellenme zamanı. API'den gelen tarih verisini temsil eder.
    val updatedAt: String,
    // Ürün ile ilişkili kategori bilgisi.
    val category: Category
)

// 'Category' verisi, bir ürünün hangi kategoriye ait olduğunu belirtir.
// Bu veri sınıfı, kategorinin tüm bilgilerini içerir.
data class Category(
    // Kategorinin benzersiz kimliği.
    val id: Int,
    // Kategorinin adı.
    val name: String,
    // Kategoriyi temsil eden görselin URL'si.
    val image: String,
    // Kategorinin oluşturulma zamanı.
    val creationAt: String,
    // Kategorinin güncellenme zamanı.
    val updatedAt: String
)