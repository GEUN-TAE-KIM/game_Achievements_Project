package org.cream.geuntae_hobby.repository.myinfo

import org.cream.geuntae_hobby.database.MyInfoItemDao
import org.cream.geuntae_hobby.model.MyInfoItem
import javax.inject.Inject

class MyInfoLocalDataSource @Inject constructor(
    private val dao: MyInfoItemDao

) : MyInfoDataSource {

    override suspend fun addCartItem(myInfoItem: MyInfoItem) {
        dao.insert(myInfoItem)
    }

    override suspend fun getCartItems(): List<MyInfoItem> {
        return dao.load()
    }
}