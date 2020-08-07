package com.binar.loginsharedpreferenceapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    companion object {
        val SP_NAME = "data_login"
        val FIELD_USERNAME = "username"
        val FIELD_PASSWORD = "12345"
        val STATUS_LOGIN = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        this.supportActionBar?.hide()

        val sharedPreferences = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val defaultUsername = sharedPreferences.getString(FIELD_USERNAME, "No Data")
        val defaultPassword = sharedPreferences.getString(FIELD_PASSWORD, "No Password")
        val defaultLogin = sharedPreferences.getBoolean(STATUS_LOGIN.toString(), false)

        btn_login.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString(FIELD_USERNAME, et_username.text.toString())
            editor.putString(FIELD_PASSWORD, et_password.text.toString())

            if (cb_remember.isChecked) editor.putBoolean(STATUS_LOGIN.toString(), true)
            else editor.putBoolean(STATUS_LOGIN.toString(), false)

            val isSaved = editor.commit()
            if (isSaved) Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            else Toast.makeText(this, "Data not saved", Toast.LENGTH_LONG).show()

            val intentLogin = Intent(this, MainActivity::class.java)
            startActivity(intentLogin)
            finish()
        }
    }
}