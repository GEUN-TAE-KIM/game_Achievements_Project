package org.cream.geuntae_hobby.repository.productdetail

import org.cream.geuntae_hobby.model.Product

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId: String): Product

}