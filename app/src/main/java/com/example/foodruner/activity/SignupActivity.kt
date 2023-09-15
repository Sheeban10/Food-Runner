package com.example.foodruner.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodruner.R
import com.example.foodruner.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var btnBack : ImageButton
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etNumber: EditText
    lateinit var etAddress: EditText
    lateinit var etPassword : EditText
    lateinit var etConfirmPass: EditText
    lateinit var btnSignUp : Button
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnBack = binding.btnBack

        etName = binding.etName
        etEmail = binding.etEmail
        etNumber = binding.etMobileNumber
        etAddress = binding.etAddress
        etPassword = binding.etPassword
        etConfirmPass = binding.etConfirmPassword
        btnSignUp = binding.btnSignUp

        firebaseAuth = FirebaseAuth.getInstance()

        sharedPreferences = getSharedPreferences(getString(R.string.shared_preference), MODE_PRIVATE)


        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnSignUp.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPass = etConfirmPass.text.toString()
            val name = etName.text.toString()
            val number = etNumber.text.toString()
            val address= etAddress.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty() && name.isNotEmpty() && number.isNotEmpty() && address.isNotEmpty()){
                if (password == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            savePreference()
                            finish()
                        }else{
                            Toast.makeText(this, "Create Account Failed", Toast.LENGTH_SHORT).show()
                        }

                    }
                }else {
                    Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(this, "please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun savePreference(){
        sharedPreferences.edit().putString("name", etName.toString()).apply()
        sharedPreferences.edit().putString("email", etEmail.toString()).apply()
        sharedPreferences.edit().putString("number", etNumber.toString()).apply()
        sharedPreferences.edit().putString("address", etAddress.toString()).apply()

    }

}