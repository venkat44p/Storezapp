package com.example.storezaapdemo3.activities

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
import com.example.storezaapdemo3.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var loginlink: TextView
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()

        //hide status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        name = findViewById(R.id.etname)
        email = findViewById(R.id.etemail)
        password = findViewById(R.id.etpassword)
        register = findViewById(R.id.btnregister)
        loginlink = findViewById(R.id.loginlink)

        loginlink.setOnClickListener(this)
        register.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnregister -> registerUser()
            R.id.loginlink -> switchOnLogin()
        }
    }

    private fun registerUser() {
        val userName = name.text.toString()
        val userEmail = email.text.toString()
        val userPassword = password.text.toString()

        if (userName.isEmpty()) {
            name.requestFocus()
            name.error = "Please enter your name"
            return
        }
        if (userEmail.isEmpty()) {
            email.requestFocus()
            email.error = "Please enter your email"
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
            password.error = "Please enter your password"
            return
        }

        val call = RetrofitClient
            .getInstance()
            .getApi()
            .register(userName, userEmail, userPassword)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                val registerResponse = response.body()
                if (response.isSuccessful) {
                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                    Toast.makeText(
                        this@SignUpActivity,
                        registerResponse.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@SignUpActivity,
                        registerResponse.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@SignUpActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun switchOnLogin() {
        val i = Intent(this@SignUpActivity, LoginActivity::class.java)
        startActivity(i)
    }
}
