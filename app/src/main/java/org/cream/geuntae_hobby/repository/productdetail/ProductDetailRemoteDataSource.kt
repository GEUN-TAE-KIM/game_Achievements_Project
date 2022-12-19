package org.cream.geuntae_hobby.repository.productdetail

import org.cream.geuntae_hobby.model.Product
import org.cream.geuntae_hobby.network.ApiClient

class ProductDetailRemoteDataSource(
    private val api: ApiClient
) : ProductDetailDataSource {

    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}