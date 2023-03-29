package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
    }

    fun miss3(view: View) {
        val intent=Intent(this@PasswordActivity, CreateActivity::class.java)
        startActivity(intent)
        finish()
    }
}