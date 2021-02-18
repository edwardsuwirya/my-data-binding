package com.enigmacamp.mydatabinding

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter

object LikesBindingAdapter {
    @BindingAdapter("hotCustomer")
    @JvmStatic
    fun setHotCustomer(textView: TextView, totalLikes: Int) {
        if (totalLikes in 0..10) {
            textView.setTextColor(Color.parseColor("#000000"))
        } else if (totalLikes in 11..50) {
            textView.setTextColor(Color.parseColor("#F6AB49"))
        } else {
            textView.setTextColor(Color.parseColor("#D71E3E"))

        }
    }
}