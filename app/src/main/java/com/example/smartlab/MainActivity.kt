package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        val timer = object :CountDownTimer(5000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                }

            override fun onFinish() {
                Intent(this@MainActivity, ActivityOnboard::class.java).apply{
                    startActivity(this)
                }
                finish()
            }
        }
        timer.start()
    }
}