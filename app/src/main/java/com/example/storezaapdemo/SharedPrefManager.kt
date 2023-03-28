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

    fun getUser(): User? {
        val id = sharedPreferences?.getInt("id", -1)
        val username = sharedPreferences?.getString("username", null)
        val email = sharedPreferences?.getString("email", null)
        if (id == -1 || username == null || email == null) {
            return null
        }
        return id?.let { User(it, username, email) }
    }

    fun removeUser() {
        val editor = sharedPreferences?.edit()
        if (editor != null) {
            editor.remove("id")
        }
        if (editor != null) {
            editor.remove("username")
        }
        if (editor != null) {
            editor.remove("email")
        }
        editor?.apply()
    }

    fun logout() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        editor!!.clear()
        editor!!.apply()
    }
}