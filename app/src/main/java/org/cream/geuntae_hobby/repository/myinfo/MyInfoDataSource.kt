package org.cream.geuntae_hobby.repository.myinfo

import org.cream.geuntae_hobby.model.MyInfoItem

interface MyInfoDataSource {

    suspend fun addCartItem(myInfoItem: MyInfoItem)

    suspend fun getCartItems(): List<MyInfoItem>
}