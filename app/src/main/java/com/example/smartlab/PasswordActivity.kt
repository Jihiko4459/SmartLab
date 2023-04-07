package com.example.smartlab

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import `in`.aabhasjindal.otptextview.OtpTextView


class PasswordActivity : AppCompatActivity() {
    lateinit var but1:AppCompatButton
    lateinit var otp1:OtpTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        but1=findViewById(R.id.button3)
    }

    fun miss3(view: View) {
        val intent=Intent(this@PasswordActivity, CreateActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun num1(view: View) {


       // but1.setOnTouchListener(OnTouchListener())
       /* if(but1.isPressed) {
            but1.setOnClickListener {
                but1.setTextColor(Color.parseColor("white"))
            }
        }else {
            but1.setOnClickListener {
                but1.setTextColor(Color.parseColor("black"))
            }
        }*/
    }
    fun num2(view: View) {}
    fun num3(view: View) {}
    fun num4(view: View) {}
    fun num5(view: View) {}
    fun num6(view: View) {}
    fun num7(view: View) {}
    fun num8(view: View) {}
    fun num9(view: View) {}
    fun num0(view: View) {}
    fun del(view: View) {}
}