package org.cream.geuntae_hobby.repository.productdetail2

import org.cream.geuntae_hobby.model.Product

interface ProductDetailDataSource2 {

    suspend fun getProductDetail2(productId: String): Product

}