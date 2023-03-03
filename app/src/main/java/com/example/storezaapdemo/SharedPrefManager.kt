package com.example.storezaapdemo

import android.content.Context
import android.content.SharedPreferences
import com.example.storezaapdemo.model.User

class SharedPrefManager(private val context: Context) {
    private val SHARED_PREF_NAME = "thecodingshef"
    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    fun saveUser(user: User) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        editor!!.putInt("id", user.id)
        editor!!.putString("username", user.username)
        editor!!.putString("email", user.email)
        editor!!.putBoolean("logged", true)
        editor!!.apply()
    }

    fun isLoggedIn(): Boolean {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("logged", false)
    }

    fun getUser(): User {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return User(
            sharedPreferences!!.getInt("id", -1),
            sharedPreferences!!.getString("username", null),
            sharedPreferences!!.getString("email", null)
        )
    }

    fun logout() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        editor!!.clear()
        editor!!.apply()
    }
}