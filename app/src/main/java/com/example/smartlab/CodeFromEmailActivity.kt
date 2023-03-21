package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CodeFromEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_from_email)
    }

    fun back(view: View) {
        val intent= Intent(this@CodeFromEmailActivity, RegandLogActivity::class.java)
        startActivity(intent)
    }
}