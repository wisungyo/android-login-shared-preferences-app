package com.binar.loginsharedpreferenceapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        val preferences = SharedPreferences(this)
        tv_hello.text = preferences.getUsername()

        btn_clear.setOnClickListener {
            preferences.clearData()
            tv_hello.text = preferences.getUsername()
        }
    }
}