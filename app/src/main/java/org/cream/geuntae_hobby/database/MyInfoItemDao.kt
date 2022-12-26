package org.cream.geuntae_hobby.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.cream.geuntae_hobby.model.MyInfoItem

@Dao
interface MyInfoItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myInfoItem: MyInfoItem)

    @Query("SELECT * FROM cart_item")
    suspend fun load(): List<MyInfoItem>
}