package org.cream.geuntae_hobby.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.cream.geuntae_hobby.repository.myinfo.MyInfoDataSource
import org.cream.geuntae_hobby.repository.myinfo.MyInfoLocalDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    // 남기기
    @Binds
    abstract fun bindCartItemDataSource(dataSource: MyInfoLocalDataSource): MyInfoDataSource

}
