package org.cream.udemshoppingproject.repository.productdetail

import org.cream.udemshoppingproject.model.Product
import org.cream.udemshoppingproject.network.ApiClient

class ProductDetailRemoteDataSource(
    private val api: ApiClient
) : ProductDetailDataSource {

    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}