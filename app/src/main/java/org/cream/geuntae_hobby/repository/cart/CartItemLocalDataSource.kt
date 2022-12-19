package org.cream.geuntae_hobby.repository.cart

import org.cream.geuntae_hobby.database.CartItemDao
import org.cream.geuntae_hobby.model.CartItem
import javax.inject.Inject
import javax.inject.Singleton

class CartItemLocalDataSource @Inject constructor(
    private val dao: CartItemDao
) : CartItemDataSource {

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }
}