package org.cream.udemshoppingproject.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.cream.udemshoppingproject.assets.AssetLoder
import org.cream.udemshoppingproject.repository.HomeAssetDataSource
import org.cream.udemshoppingproject.repository.HomeRepository
import org.cream.udemshoppingproject.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {

            val repository = HomeRepository(HomeAssetDataSource(AssetLoder(context)))
            return HomeViewModel(repository) as T

        } else {

            throw  IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")

        }
    }
}