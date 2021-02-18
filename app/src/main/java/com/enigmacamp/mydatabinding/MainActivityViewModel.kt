package com.enigmacamp.mydatabinding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var _customerLiveData = MutableLiveData<Customer>()
    val customerLiveData: LiveData<Customer>
        get() {
            return _customerLiveData
        }
    var newComment = ""

    val maxLikes = 100

    private var _postAComment = MutableLiveData(false)
    val postAComment: LiveData<Boolean>
        get() {
            return _postAComment
        }

    init {
        val customer = Customer("Jution", "Lampung", 0, "")
        _customerLiveData.value = customer
        newComment = customer.comment
    }

    fun onLike() {
        val customer = _customerLiveData.value
        customer?.apply {
            if (likes < maxLikes) {
                val customerLike = copy(likes = likes + 1)
                _customerLiveData.value = customerLike
            }
        }
    }

    fun onPostComment() {
        val customer = _customerLiveData.value
        customer?.apply {
            val customerComment = copy(comment = newComment)
            _customerLiveData.value = customerComment
            Log.d("ViewModel", customerLiveData.value.toString())
        }
        _postAComment.value = true
    }

}