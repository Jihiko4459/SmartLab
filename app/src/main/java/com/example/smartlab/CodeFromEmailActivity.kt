package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CodeFromEmailActivity : AppCompatActivity() {
    lateinit var email: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_from_email)
        email = intent.getStringExtra("email")!!
        GlobalScope.launch {
            val timer = object: CountDownTimer(5900, 100){
                override fun onTick(p0: Long) {

                }

                override fun onFinish() {

                }
            }
        }
    }

    fun back(view: View) {
        val intent= Intent(this@CodeFromEmailActivity, RegandLogActivity::class.java)
        startActivity(intent)
    }
}