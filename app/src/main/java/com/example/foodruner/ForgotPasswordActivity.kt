package com.example.foodruner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodruner.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity: AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}