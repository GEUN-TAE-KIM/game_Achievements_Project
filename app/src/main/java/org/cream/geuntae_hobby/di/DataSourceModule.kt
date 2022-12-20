package org.cream.geuntae_hobby.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.cream.geuntae_hobby.repository.cart.CartItemDataSource
import org.cream.geuntae_hobby.repository.cart.CartItemLocalDataSource
import org.cream.geuntae_hobby.repository.category.CategoryDataSource
import org.cream.geuntae_hobby.repository.category.CategoryRemoteDataSource
import org.cream.geuntae_hobby.repository.categorydetail.CategoryDetailDataSource
import org.cream.geuntae_hobby.repository.categorydetail.CategoryDetailRemoteDataSource
import org.cream.geuntae_hobby.repository.home.HomeAssetDataSource
import org.cream.geuntae_hobby.repository.home.HomeDataSource
import org.cream.geuntae_hobby.repository.productdetail.ProductDetailDataSource
import org.cream.geuntae_hobby.repository.productdetail.ProductDetailRemoteDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

 /* @Binds
    abstract fun bindCartItemDataSource(dataSource: CartItemLocalDataSource): CartItemDataSource

    @Binds
    abstract fun bindHomeDataSource(dataSource: HomeAssetDataSource): HomeDataSource */

    @Binds
    abstract fun bindCategoryDataSource(dataSource: CategoryRemoteDataSource): CategoryDataSource

    @Binds
    abstract fun bindCategoryDetailDataSource(dataSource: CategoryDetailRemoteDataSource): CategoryDetailDataSource

    @Binds
    abstract fun bindProductDetailDataSource(dataSource: ProductDetailRemoteDataSource): ProductDetailDataSource

}
