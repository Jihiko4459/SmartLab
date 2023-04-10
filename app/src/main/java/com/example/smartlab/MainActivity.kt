package com.example.smartlab

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    var skip: SharedPreferences?=null
    var state = 0
    var checkT: Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        skip=getSharedPreferences(TABLE, MODE_PRIVATE)
        state = skip?.getInt("button_state", 0)!!
        val timer = object :CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {

                checkT = state==1
                }

            override fun onFinish() {
                if (checkT) {
                    val intent =Intent(this@MainActivity, RegandLogActivity::class.java)
                        startActivity(intent)
                }else{
                    val intent =Intent(this@MainActivity, ActivityOnboard::class.java)
                    startActivity(intent)
                }
                finish()
            }
        }
        timer.start()
    }
}