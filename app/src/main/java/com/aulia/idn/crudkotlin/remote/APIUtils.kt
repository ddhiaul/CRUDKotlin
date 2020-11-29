package com.aulia.idn.crudkotlin.remote

object APIUtils {

    private const val API_URL = "http://192.168.1.7/marketplace/index.php/"

    val productService: ProductService
        get() = RetrofitClient.getClient(API_URL)?.create(ProductService::class.java)!!

}