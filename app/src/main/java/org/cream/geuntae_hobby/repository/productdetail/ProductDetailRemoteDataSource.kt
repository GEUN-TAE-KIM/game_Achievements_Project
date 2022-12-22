package org.cream.geuntae_hobby.repository.productdetail

import org.cream.geuntae_hobby.model.Product
import org.cream.geuntae_hobby.network.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

class ProductDetailRemoteDataSource @Inject constructor(
    private val api: ApiClient
) : ProductDetailDataSource {

    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}