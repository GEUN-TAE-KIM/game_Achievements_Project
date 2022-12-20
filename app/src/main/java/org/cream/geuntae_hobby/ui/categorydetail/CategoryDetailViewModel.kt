package org.cream.geuntae_hobby.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cream.geuntae_hobby.model.Promotion
import org.cream.geuntae_hobby.model.TopSelling
import org.cream.geuntae_hobby.repository.categorydetail.CategoryDetailRepository
import javax.inject.Inject


class CategoryDetailViewModel (private val categoryDetailRepository: CategoryDetailRepository) :
    ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling: LiveData<TopSelling> = _topSelling

    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions

    init {
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions
        }

    }

}