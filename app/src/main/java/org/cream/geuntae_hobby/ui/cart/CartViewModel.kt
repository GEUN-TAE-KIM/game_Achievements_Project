package org.cream.geuntae_hobby.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cream.geuntae_hobby.model.CartItem
import org.cream.geuntae_hobby.repository.cart.CartRepository
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartRepository: CartRepository) : ViewModel() {

    private val _items = MutableLiveData<List<CartItem>>()
    val items: LiveData<List<CartItem>> = _items

    init {
        loadCartItem()
    }

    private fun loadCartItem() {
        viewModelScope.launch {
            _items.value = cartRepository.getCartItems()
        }
    }
}