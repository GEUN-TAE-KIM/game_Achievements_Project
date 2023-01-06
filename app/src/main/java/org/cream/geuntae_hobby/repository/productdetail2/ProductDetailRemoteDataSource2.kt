package org.cream.geuntae_hobby.repository.productdetail2

import org.cream.geuntae_hobby.model.Product
import org.cream.geuntae_hobby.network.ApiClient
import javax.inject.Inject

class ProductDetailRemoteDataSource2 @Inject constructor(
    private val api: ApiClient
) : ProductDetailDataSource2 {

    override suspend fun getProductDetail2(productId: String): Product {
        return api.getProductDetail2(productId)
    }
}