package org.cream.geuntae_hobby.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.cream.geuntae_hobby.model.MyInfoItem

@Database(entities = [MyInfoItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): MyInfoItemDao
}