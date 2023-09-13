package com.example.foodruner

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodruner.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences(getString(R.string.shared_preference), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn){
            startActivity(Intent(this, MainActivity::class.java))
        } else setContentView(view)


        binding.btnLogin.setOnClickListener {

        }

        binding.tvForgotPw.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordActivity::class.java))

        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreference(){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

    }
}