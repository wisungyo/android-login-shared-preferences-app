package com.binar.loginsharedpreferenceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class SplashScreen : AppCompatActivity() {
    lateinit var handler : Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        this.supportActionBar?.hide()
        handler = Handler()
        val preferences = SharedPreferences(this)
        Log.d("DEBUGGING", "isLogin is ${preferences.getIsLogin()}")

        val isLogin = preferences.getIsLogin()
        if (isLogin == "true") {
            handler.postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        } else {
            handler.postDelayed({
                val intent = Intent(this, LoginPage::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        }
    }
}