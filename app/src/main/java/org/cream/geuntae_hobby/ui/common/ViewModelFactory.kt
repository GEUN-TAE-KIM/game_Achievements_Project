package org.cream.geuntae_hobby.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.cream.geuntae_hobby.AssetLoader
import org.cream.geuntae_hobby.ServiceLocator
import org.cream.geuntae_hobby.repository.category.CategoryRemoteDataSource
import org.cream.geuntae_hobby.repository.category.CategoryRepository
import org.cream.geuntae_hobby.repository.categorydetail.CategoryDetailRemoteDataSource
import org.cream.geuntae_hobby.repository.categorydetail.CategoryDetailRepository
import org.cream.geuntae_hobby.repository.home.HomeAssetDataSource
import org.cream.geuntae_hobby.repository.home.HomeRepository
import org.cream.geuntae_hobby.repository.productdetail.ProductDetailRemoteDataSource
import org.cream.geuntae_hobby.repository.productdetail.ProductDetailRepository
import org.cream.geuntae_hobby.ui.cart.CartViewModel
import org.cream.geuntae_hobby.ui.category.CategoryViewModel
import org.cream.geuntae_hobby.ui.categorydetail.CategoryDetailViewModel
import org.cream.geuntae_hobby.ui.home.HomeViewModel
import org.cream.geuntae_hobby.ui.productdetail.ProductDetailViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
           /* modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository = ProductDetailRepository(ProductDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                ProductDetailViewModel(repository, ServiceLocator.provideCartRepository(context)) as T
            }*/
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(ServiceLocator.provideCartRepository(context)) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}