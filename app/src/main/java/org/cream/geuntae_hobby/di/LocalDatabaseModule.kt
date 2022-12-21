package org.cream.geuntae_hobby.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.cream.geuntae_hobby.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context)
     = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "AppDatabase.db"
            ).build()

    @Provides
    @Singleton
    fun provideDao(database: AppDatabase) = database.cartItemDao()


}