package com.enigmacamp.mydatabinding

import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter

object LikesBindingAdapter {
    @BindingAdapter("hotCustomer", "maxLikes", requireAll = true)
    @JvmStatic
    fun setHotCustomer(textView: TextView, totalLikes: Int, maxLikes: Int) {
        if (totalLikes < maxLikes) {
            when (totalLikes) {
                in 0..10 -> {
                    textView.setTextColor(Color.parseColor("#000000"))
                }
                in 11..50 -> {
                    textView.setTextColor(Color.parseColor("#F6AB49"))
                }
                else -> {
                    textView.setTextColor(Color.parseColor("#D71E3E"))
                }
            }
        } else {
            Toast.makeText(textView.context, "Maximum likes", Toast.LENGTH_SHORT).show()
        }
    }
}