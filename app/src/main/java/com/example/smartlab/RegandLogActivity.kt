package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegandLogActivity : AppCompatActivity() {
    lateinit var email:EditText
    val pattern=("[a-z]{1,100}"+"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regand_log)
        email=findViewById(R.id.editTextTextEmailAddress)
    }
    fun emailValid(text:String):Boolean{
        return Pattern.compile(pattern).matcher(text).matches()
    }
    fun next(view: View) {
        if (email.text.toString().isNotEmpty()){
            if(emailValid(email.text.toString())){
                val intent= Intent(this@RegandLogActivity, CodeFromEmailActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Заполните правильно все поля", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
        }

    }
}