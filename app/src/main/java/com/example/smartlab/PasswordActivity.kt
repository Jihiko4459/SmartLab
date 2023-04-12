package com.example.smartlab

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnTouchListener
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import `in`.aabhasjindal.otptextview.OtpTextView


class PasswordActivity : AppCompatActivity() {
    var skip: SharedPreferences?=null
    private lateinit var firstPin : ImageView
    private lateinit var secondPin :ImageView
    private lateinit var firdPin :ImageView
    private lateinit var fourPin :ImageView
    private var numberButtons = mutableListOf<AppCompatButton>()
    private var passCount :Int = 0
    private var passFull :Boolean = false
    private lateinit var del_button : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        skip=getSharedPreferences(TABLE, MODE_PRIVATE)

        numberButtons.add(0,findViewById(R.id.button16))
        numberButtons.add(1,findViewById(R.id.button3))
        numberButtons.add(2,findViewById(R.id.button4))
        numberButtons.add(3,findViewById(R.id.button9))
        numberButtons.add(4,findViewById(R.id.button10))
        numberButtons.add(5,findViewById(R.id.button11))
        numberButtons.add(6,findViewById(R.id.button12))
        numberButtons.add(7,findViewById(R.id.button13))
        numberButtons.add(8,findViewById(R.id.button14))
        numberButtons.add(9,findViewById(R.id.button15))

        firstPin = findViewById(R.id.image5)
        secondPin = findViewById(R.id.image6)
        firdPin = findViewById(R.id.image8)
        fourPin = findViewById(R.id.image9)

        del_button = findViewById(R.id.imageButton)

        del_button.setOnClickListener{
            passCount--
            Log.d("COUNTER_BUT1","$passCount")
            nextActivity()
        }
        for (button in numberButtons) {
            button.setOnClickListener {
                passCount++
                Log.d("COUNTER_BUT1","$passCount")
                nextActivity()
            }
        }
    }

    fun miss3(view: View) {
        val intent=Intent(this@PasswordActivity, CreateActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun nextActivity(){

        when (passCount) {
            1 -> firstPin.background = resources.getDrawable(R.drawable.otp_fill, null)
            2 -> secondPin.background = resources.getDrawable(R.drawable.otp_fill, null)
            3 -> firdPin.background = resources.getDrawable(R.drawable.otp_fill, null)
            4 -> fourPin.background = resources.getDrawable(R.drawable.otp_fill, null)
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }
        if (passCount == 4) {
            passFull = true
            Log.d("COUNTER_STATUS", "$passFull")
            if (passFull) {
                val intent = Intent(this@PasswordActivity, CreateActivity::class.java)
                startActivity(intent)
                savestate(1)
                finish()
            }
        }


    }
    private fun savestate(s:Int){
        val editor=skip?.edit()
        editor?.putInt("pass_state", s)
        editor?.apply()
    }
}