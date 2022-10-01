package org.cream.udemshoppingproject.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.cream.udemshoppingproject.model.Category
import org.cream.udemshoppingproject.model.CategoryDetail
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories() : List<Category>

    @GET("fashion_female.json")
    suspend fun getCategoryDetail(): CategoryDetail

    // 데이터를 구성하면 이렇게
   /* @GET("{categoryID}.json")
    suspend fun getCategoryDetail(@Path("categoryId") categoryId: String): CategoryDetail*/

    companion object{

        private val baseUrl = "https://udemshoppractice-default-rtdb.asia-southeast1.firebasedatabase.app/"

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