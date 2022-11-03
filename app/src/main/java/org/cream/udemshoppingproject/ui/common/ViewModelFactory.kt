package org.cream.udemshoppingproject.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.cream.udemshoppingproject.ServiceLocator
import org.cream.udemshoppingproject.assets.AssetLoder
import org.cream.udemshoppingproject.network.ApiClient
import org.cream.udemshoppingproject.repository.category.CategoryRemoteDataSource
import org.cream.udemshoppingproject.repository.category.CategoryRepository
import org.cream.udemshoppingproject.repository.categorydetail.CategoryDetailRemoteDataSource
import org.cream.udemshoppingproject.repository.categorydetail.CategoryDetailRepository
import org.cream.udemshoppingproject.repository.home.HomeAssetDataSource
import org.cream.udemshoppingproject.repository.home.HomeRepository
import org.cream.udemshoppingproject.repository.productdetail.ProductDetailRemoteDataSource
import org.cream.udemshoppingproject.repository.productdetail.ProductDetailRepository
import org.cream.udemshoppingproject.ui.category.CategoryViewModel
import org.cream.udemshoppingproject.ui.categorydetail.CategoryDetailViewModel
import org.cream.udemshoppingproject.ui.home.HomeViewModel
import org.cream.udemshoppingproject.ui.productdetail.ProductDetailViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return when {

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {

                val repository = HomeRepository(HomeAssetDataSource(AssetLoder(context)))
                return HomeViewModel(repository) as T
            }

            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository =
                    CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
                return CategoryViewModel(repository) as T

            }

            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository =
                    CategoryDetailRepository(CategoryDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                return CategoryDetailViewModel(repository) as T
            }

            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository =
                    ProductDetailRepository(ProductDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                ProductDetailViewModel(repository) as T
            }

            else -> {

                throw  IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")

            }
        }
    }
}