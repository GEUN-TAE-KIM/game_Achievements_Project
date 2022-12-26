package org.cream.geuntae_hobby.repository.myinfo

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.cream.geuntae_hobby.model.MyInfoItem
import org.cream.geuntae_hobby.model.Product
import javax.inject.Inject

class MyInfoRepository @Inject constructor(
    private val localDataSource: MyInfoLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun addCartItem(product: Product) {
        withContext(ioDispatcher) {
            val myInfoItem = MyInfoItem(
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName ?: "",
                thumbnailImageUrl = product.thumbnailImageUrl ?: "",
                type = product.type ?: "",
                amount = 1
            )
            localDataSource.addCartItem(myInfoItem)
        }
    }

    suspend fun getCartItems(): List<MyInfoItem> {
        return withContext(ioDispatcher) {
            localDataSource.getCartItems()
        }
    }
}