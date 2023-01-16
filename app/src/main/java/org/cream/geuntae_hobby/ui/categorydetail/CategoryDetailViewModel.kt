package org.cream.geuntae_hobby.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.cream.geuntae_hobby.model.CategoryDetail
import org.cream.geuntae_hobby.model.Promotion
import org.cream.geuntae_hobby.model.TopSelling
import org.cream.geuntae_hobby.network.ApiClient
import org.cream.geuntae_hobby.repository.categorydetail.CategoryDetailRepository
import org.cream.geuntae_hobby.ui.common.Event
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val categoryDetailRepository: CategoryDetailRepository,
) : ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling: LiveData<TopSelling> = _topSelling

    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions


    private val _openCategoryDetailEvent = MutableLiveData<Event<CategoryDetail>>()
    val openCategoryDetailEvent: LiveData<Event<CategoryDetail>> = _openCategoryDetailEvent

    fun openCategoryDetailEvent(categoryId: CategoryDetail) {
        _openCategoryDetailEvent.value = Event(categoryId)
    }

    fun loadCategoryDetail(categoryId: String) {
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail(categoryId)
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions

        }

    }


}