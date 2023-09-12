package com.example.foodruner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodruner.databinding.ActivitySignupBinding

class SignupActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}