package com.example.storezaapdemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.storezaapdemo.R
import com.example.storezaapdemo.RetrofitClient
import com.example.storezaapdemo.SharedPrefManager
import com.example.storezaapdemo.ui.profile.ProfileFragment
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var registerlink: TextView
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //hide actionbar
        supportActionBar?.hide()

        //hide status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        email = findViewById(R.id.etemail)
        password = findViewById(R.id.etpassword)
        login = findViewById(R.id.btnlogin)
        registerlink = findViewById(R.id.registerlink)

        registerlink.setOnClickListener(this)
        login.setOnClickListener(this)

        val signUpText = findViewById<TextView>(R.id.registerlink)
        signUpText.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        sharedPrefManager = SharedPrefManager(applicationContext)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnlogin -> userLogin()
            R.id.registerlink -> switchOnRegister()
        }
    }

    private fun userLogin() {
        val userEmail = email.text.toString()
        val userPassword = password.text.toString()

        if (userEmail.isEmpty()) {
            email.requestFocus()
            email.error = "Please enter your name"
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            email.requestFocus()
            email.error = "Please enter correct email"
            return
        }
        if (userPassword.isEmpty()) {
            password.requestFocus()
            password.error = "Please enter your password"
            return
        }
        if (userPassword.length < 8) {
            password.requestFocus()
            password.error = "Please enter your name"
            return
        }

        val call: Call<ResponseBody> =
            RetrofitClient.getInstance().getApi().login(userEmail, userPassword)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val loginResponse = response.body()

                if (response.isSuccessful) {
                    val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    Toast.makeText(this@LoginActivity, loginResponse.toString(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun switchOnRegister() {
        val i = Intent(this@LoginActivity, ProfileActivity::class.java)
        startActivity(i)
    }

    override fun onStart() {
        super.onStart()

        if (sharedPrefManager.isLoggedIn()) {
            val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}