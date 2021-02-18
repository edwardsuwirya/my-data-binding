package com.enigmacamp.mydatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var _customerLiveData = MutableLiveData<Customer>()
    val customerLiveData: LiveData<Customer>
        get() {
            return _customerLiveData
        }

    init {
        _customerLiveData.value = Customer("Jution", "Lampung", 0)
    }

    fun onLike() {
        val customer = _customerLiveData.value
        customer?.apply {
            val customerLike = copy(likes = likes + 1)
            _customerLiveData.value = customerLike
        }
    }

}