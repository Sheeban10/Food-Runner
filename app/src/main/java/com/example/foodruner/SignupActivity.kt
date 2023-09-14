package com.example.foodruner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.findViewTreeOnBackPressedDispatcherOwner
import androidx.appcompat.app.AppCompatActivity
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
                            val intent = Intent(this,LoginActivity::class.java)
                            startActivity(intent)
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

}