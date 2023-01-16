package org.cream.geuntae_hobby.ui.myinfodetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cream.geuntae_hobby.model.MyInfoDetails
import org.cream.geuntae_hobby.repository.myinfodetails.MyInfoDetailsRepository
import org.cream.geuntae_hobby.ui.common.Event
import javax.inject.Inject

@HiltViewModel
class MyInfoDetailsViewModel @Inject constructor(
    private val myInfoDetailsRepository: MyInfoDetailsRepository,
) : ViewModel() {

    private val _items = MutableLiveData<List<MyInfoDetails>>()
    val items: LiveData<List<MyInfoDetails>> = _items

    private val _openCategoryEvent = MutableLiveData<Event<MyInfoDetails>>()
    val openCategoryEvent: LiveData<Event<MyInfoDetails>> = _openCategoryEvent

    init {
        loadCategory()
    }

    fun openCategoryDetail(myInfoDetails: MyInfoDetails) {
        _openCategoryEvent.value = Event(myInfoDetails)
    }

    private fun loadCategory() {
        // TODO repository에 데이터 요청
        viewModelScope.launch {
            val myInfoDetails = myInfoDetailsRepository.getMyInfoDetails()
            _items.value = myInfoDetails
        }
    }
}