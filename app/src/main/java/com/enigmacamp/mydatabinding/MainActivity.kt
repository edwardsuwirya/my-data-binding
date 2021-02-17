package com.enigmacamp.mydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var nameTextView: TextView
    lateinit var addressTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        initViewModel()
        subscribe()
    }

    private fun initUi() {
        nameTextView = findViewById(R.id.name_textView)
        addressTextView = findViewById(R.id.address_textView)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.customerLiveData.observe(this, Observer {
            nameTextView.setText(it.name)
            addressTextView.setText(it.address)
        })
    }
}