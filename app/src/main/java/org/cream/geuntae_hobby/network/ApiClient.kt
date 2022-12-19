package org.cream.geuntae_hobby.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.cream.geuntae_hobby.model.Category
import org.cream.geuntae_hobby.model.CategoryDetail
import org.cream.geuntae_hobby.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories() : List<Category>

    // json category_id 아이디 설정하는 것
    @GET("from-darkSouls1.json")
    suspend fun getCategoryDetail(): CategoryDetail

    @GET("products/{productId}.json")
    suspend fun getProductDetail(@Path("productId") productId: String): Product

    // 데이터를 구성하면 이렇게
   /* @GET("{categoryID}.json")
    suspend fun getCategoryDetail(@Path("categoryId") categoryId: String): CategoryDetail*/

    companion object{

        private const val baseUrl = "https://shop-90b5b-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create(): ApiClient{

            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}