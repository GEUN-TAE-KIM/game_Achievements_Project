package org.cream.geuntae_hobby.repository.productdetail

import org.cream.geuntae_hobby.model.Product
import javax.inject.Inject
import javax.inject.Singleton


class ProductDetailRepository (
    private val remoteDataSource: ProductDetailDataSource
) {

    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}