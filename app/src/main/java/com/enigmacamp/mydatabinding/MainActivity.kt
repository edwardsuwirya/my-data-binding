package com.enigmacamp.mydatabinding

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.mydatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewmodel = viewModel
        }
        subscribe()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.postAComment.observe(this, Observer {
            if (it) {
                binding.postButton.isEnabled = false
                binding.postButton.setTextColor(Color.parseColor("#d8d8d8"))
                binding.commentEditText.setText("")
                binding.commentEditText.isEnabled = false
                val customer = viewModel.customerLiveData.value
                Toast.makeText(this, "Added a comment \n ${customer?.comment}", Toast.LENGTH_SHORT)
                    .show()
            } else {
                binding.postButton.isEnabled = true
                binding.commentEditText.isEnabled = true
            }
        })
    }
}