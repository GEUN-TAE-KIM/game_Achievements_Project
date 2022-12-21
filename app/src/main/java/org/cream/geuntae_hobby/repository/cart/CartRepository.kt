package org.cream.geuntae_hobby.repository.cart

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.cream.geuntae_hobby.model.CartItem
import org.cream.geuntae_hobby.model.Product
import javax.inject.Inject
import javax.inject.Singleton

class CartRepository @Inject constructor(
    private val localDataSource: CartItemLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun addCartItem(product: Product) {
        withContext(ioDispatcher) {
            val cartItem = CartItem(
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName ?: "",
                thumbnailImageUrl = product.thumbnailImageUrl ?: "",
                type = product.type ?: "",
                amount = 1
            )
            localDataSource.addCartItem(cartItem)
        }
    }

    suspend fun getCartItems(): List<CartItem> {
        return withContext(ioDispatcher) {
            localDataSource.getCartItems()
        }
    }
}