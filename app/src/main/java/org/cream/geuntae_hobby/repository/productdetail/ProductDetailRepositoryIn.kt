package org.cream.geuntae_hobby.repository.productdetail

import org.cream.geuntae_hobby.model.Product

interface ProductDetailRepositoryIn {
    suspend fun getProductDetail(productId: String): Product
}