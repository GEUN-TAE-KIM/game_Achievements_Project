package org.cream.geuntae_hobby.repository.productdetail2

import org.cream.geuntae_hobby.model.Product
import org.cream.geuntae_hobby.repository.productdetail.ProductDetailRemoteDataSource
import org.cream.geuntae_hobby.repository.productdetail.ProductDetailRepositoryIn
import javax.inject.Inject

class ProductDetailRepository2 @Inject constructor(
    private val remoteDataSource: ProductDetailRemoteDataSource2
) : ProductDetailRepositoryIn2 {
    override suspend fun getProductDetail2(productId: String): Product {
        return remoteDataSource.getProductDetail2(productId)
    }
}