package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.smartlab.models.SendEmail
import com.example.smartlab.models.SuccessEmail
import com.example.smartlab.utils.Utils
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class RegandLogActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var button: MaterialButton
    val pattern=("[a-z0-9]{1,100}"+"@"+"[a-z]{1,10}"+"\\."+"[a-z]{1,5}")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regand_log)
        email=findViewById(R.id.editTextTextEmailAddress)
        button = findViewById(R.id.button)

        email.addTextChangedListener { text ->
            button.isEnabled = text.toString().isNotEmpty()
        }
    }
    fun emailValid(text:String):Boolean{
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun sendEmailOtp() {
        val retrofit = Utils.retroInst
        retrofit.sendEmailOtp(email.text.toString()).enqueue(object : Callback<SuccessEmail>{
            override fun onResponse(call: Call<SuccessEmail>, response: Response<SuccessEmail>) {
                if (response.code() == 200) {
                    val intent= Intent(this@RegandLogActivity, CodeFromEmailActivity::class.java)
                    intent.putExtra("email", email.text.toString()) // Закидываем на след экран email
                    startActivity(intent)
                    finish()
                } else {
                    Log.d("Error", "Fail request")
                }
            }

            override fun onFailure(call: Call<SuccessEmail>, t: Throwable) {
                Log.d("error", t.localizedMessage.toString())
            }
        })
    }
    fun next(view: View) {
        if (email.text.toString().isNotEmpty()){
            if(emailValid(email.text.toString())){
                sendEmailOtp()
            }
            else{
                Toast.makeText(this, "Заполните правильно email", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this, "Заполните email", Toast.LENGTH_LONG).show()
        }
    }
}