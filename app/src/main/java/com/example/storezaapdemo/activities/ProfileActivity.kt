package com.example.storezaapdemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.storezaapdemo.R
import com.example.storezaapdemo.SharedPrefManager

class ProfileActivity : AppCompatActivity() {

    private lateinit var etname: TextView
    private lateinit var etemail: TextView
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        supportActionBar?.hide()

        etname = findViewById(R.id.etname)
        etemail = findViewById(R.id.etemail)

        sharedPrefManager = SharedPrefManager(this)

        val userName = "Hey! " + sharedPrefManager.getUser().username
        etname.text = userName
        etemail.text = sharedPrefManager.getUser().email

    }
}
