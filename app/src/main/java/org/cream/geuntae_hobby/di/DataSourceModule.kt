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

    // api 받는 것 때문에 오류 걸리는 거 같음 처리 하는거 찾아봐서 적용 해야 할듯
    // 너무 무지성으로 데이터 소스는 이거고 뷰모델은 이거 하면 되지 하면서 넣어서 문제 인거 같음
    // 우선 api 관련된 것은 의존성 주입 삭제 하고 api 받는 것 알아보고 적용 하기
    @Binds
    abstract fun bindCartItemDataSource(dataSource: CartItemLocalDataSource): CartItemDataSource

    @Binds
    abstract fun bindCategoryDataSource(dataSource: CategoryRemoteDataSource): CategoryDataSource

    @Binds
    abstract fun bindCategoryDetailDataSource(dataSource: CategoryDetailRemoteDataSource): CategoryDetailDataSource

    @Binds
    abstract fun bindHomeDataSource(dataSource: HomeAssetDataSource): HomeDataSource

    @Binds
    abstract fun bindProductDetailDataSource(dataSource: ProductDetailRemoteDataSource): ProductDetailDataSource

}
