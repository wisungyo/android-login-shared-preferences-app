package com.binar.loginsharedpreferenceapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SharedPreferences (context: Context) {
    private val SP_NAME : String = "data_login"
    private val SP_USERNAME : String = "username"
    private val SP_PASSWORD : String = "12345"
    private val SP_IS_LOGIN : String = "false"
    private val preferences: SharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun getUsername() : String {
        return preferences.getString(SP_USERNAME, "Username").toString()
    }
    fun setUsername(username: String) {
        val editor = preferences.edit()
        editor.putString(SP_USERNAME, username)
        editor.apply()
    }

    fun getPassword() : String {
        return preferences.getString(SP_PASSWORD, "12345").toString()
    }
    fun setPassword(password: String) {
        val editor = preferences.edit()
        editor.putString(SP_PASSWORD, password)
        editor.apply()
    }

    fun getIsLogin() : String {
        return preferences.getString(SP_IS_LOGIN, "false").toString()
    }
    fun setIsLogin(isLogin: String) {
        val editor = preferences.edit()
        editor.putString(SP_IS_LOGIN, isLogin)
        editor.apply()
    }

    @SuppressLint("CommitPrefEdits")
    fun clearData() {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}