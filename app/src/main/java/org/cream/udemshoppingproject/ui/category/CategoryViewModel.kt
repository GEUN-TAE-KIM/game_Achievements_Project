package org.cream.udemshoppingproject.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cream.udemshoppingproject.model.Category
import org.cream.udemshoppingproject.repository.category.CategoryRepository

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> = _items

    init {
        loadCategory()
    }

    private fun loadCategory() {
        // TODO repository에 데이터 요청
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}