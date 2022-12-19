package org.cream.geuntae_hobby.repository.cart

import org.cream.geuntae_hobby.model.CartItem

interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)

    suspend fun getCartItems(): List<CartItem>
}