package org.cream.geuntae_hobby.ui.myinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cream.geuntae_hobby.model.MyInfoItem
import org.cream.geuntae_hobby.repository.myinfo.MyInfoRepository
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val myInfoRepository: MyInfoRepository,
) : ViewModel() {

    private val _items = MutableLiveData<List<MyInfoItem>>()
    val items: LiveData<List<MyInfoItem>> = _items

    init {
        loadCartItem()
    }

    private fun loadCartItem() {
        viewModelScope.launch {
            _items.value = myInfoRepository.getCartItems()
        }
    }
}