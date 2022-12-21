package org.cream.geuntae_hobby.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.cream.geuntae_hobby.AssetLoader
import org.cream.geuntae_hobby.repository.home.HomeAssetDataSource
import org.cream.geuntae_hobby.repository.home.HomeRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AssetModule {

    @Provides
    @Singleton
    fun providesAssetLoader(@ApplicationContext appContext: Context): AssetLoader =
        AssetLoader(appContext)

    @Provides
    @Singleton
    fun provideTodoAssetDataSource(assetLoader: AssetLoader): HomeAssetDataSource {
        return HomeAssetDataSource(assetLoader)
    }

    @Provides
    @Singleton
    fun provideTodoAssetRepository(assetDataSource: HomeAssetDataSource): HomeRepository {
        return HomeRepository(assetDataSource)
    }

}