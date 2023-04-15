package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OrderRegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_reg)
    }

    fun order(view: View) {
        val intent= Intent(this@OrderRegActivity, PayActivity::class.java)
        startActivity(intent)
    }
}