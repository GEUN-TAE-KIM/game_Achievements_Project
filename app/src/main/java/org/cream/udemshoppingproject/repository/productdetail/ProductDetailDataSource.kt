package org.cream.udemshoppingproject.repository.productdetail

import org.cream.udemshoppingproject.model.Product

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId: String): Product

}