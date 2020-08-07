package com.binar.loginsharedpreferenceapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        this.supportActionBar?.hide()

        btn_login.setOnClickListener {
            if (cb_remember.isChecked) {
                val preference = SharedPreferences(this)
                preference.setUsername(et_username.text.toString())
                preference.setPassword(et_password.text.toString())
                preference.setIsLogin("true")
            }

            val intentLogin = Intent(this, MainActivity::class.java)
            startActivity(intentLogin)
            finish()
        }
    }
}