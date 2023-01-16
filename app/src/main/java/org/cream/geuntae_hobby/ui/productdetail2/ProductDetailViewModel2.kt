package org.cream.geuntae_hobby.ui.productdetail2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cream.geuntae_hobby.model.Product
import org.cream.geuntae_hobby.repository.productdetail2.ProductDetailRepository2
import org.cream.geuntae_hobby.ui.common.Event
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel2 @Inject constructor(
    private val productDetailRepository2: ProductDetailRepository2
) : ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            _product.value = productDetailRepository2.getProductDetail2(productId)
        }
    }

}