package com.example.foodruner

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodruner.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        sharedPreferences = getSharedPreferences(getString(R.string.shared_preference), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn){
            startActivity(Intent(this, MainActivity::class.java))
        } else setContentView(view)

        etEmail = binding.etEmail
        etPassword = binding.etLoginPassword
        btnLogin = binding.btnLogin

        binding.btnLogin.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

                if (email.isNotBlank() && password.isNotBlank()){
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                        if (it.isSuccessful){
                            savePreference()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Enter Email/Password", Toast.LENGTH_SHORT).show()
                }
        }

        binding.tvForgotPw.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordActivity::class.java))

        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }
    }


    fun savePreference(){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

    }
}