package org.cream.geuntae_hobby.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.cream.geuntae_hobby.model.CartItem

@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao
}