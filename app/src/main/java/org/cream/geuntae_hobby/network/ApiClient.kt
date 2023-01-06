package org.cream.geuntae_hobby.network

import org.cream.geuntae_hobby.model.Category
import org.cream.geuntae_hobby.model.CategoryDetail
import org.cream.geuntae_hobby.model.MyInfoDetails
import org.cream.geuntae_hobby.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories(): List<Category>

    @GET("my_info_details.json")
    suspend fun getMyInfoDetails(): List<MyInfoDetails>

    @GET("{categoryId}.json")
    suspend fun getCategoryDetail(@Path("categoryId") categoryId: String): CategoryDetail

    @GET("products2/{productId}.json")
    suspend fun getProductDetail2(@Path("productId") productId: String): Product

    @GET("products/{productId}.json")
    suspend fun getProductDetail(@Path("productId") productId: String): Product

    // json category_id 아이디 설정하는 것
    /* @GET("from-darkSouls1.json")
     suspend fun getCategoryDetail(): CategoryDetail*/

    // 데이터를 구성하면 이렇게
    /* @GET("{categoryID}.json")
     suspend fun getCategoryDetail(@Path("categoryId") categoryId: String): CategoryDetail*/

    /*companion object{

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
    }*/
}