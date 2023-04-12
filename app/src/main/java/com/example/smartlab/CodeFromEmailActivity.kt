package com.example.smartlab

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartlab.databinding.ActivityCodeFromEmailBinding
import com.example.smartlab.models.SuccessEmail
import com.example.smartlab.models.SuccessToken
import com.example.smartlab.utils.Utils
import `in`.aabhasjindal.otptextview.OTPListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CodeFromEmailActivity : AppCompatActivity() {
    lateinit var email: String
    lateinit var binding: ActivityCodeFromEmailBinding
    lateinit var sharedPreferences: SharedPreferences
    var state = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeFromEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.getStringExtra("email")?.let {
            email = it
        }
        onInputCodeListener()
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
        state = sharedPreferences.getInt("pass_state", 0)
    }

    fun back(view: View) {
        val intent = Intent(this@CodeFromEmailActivity, RegandLogActivity::class.java)
        startActivity(intent)
    }

    private fun sendOtp(email: String, otp: String) {
        val retrofit = Utils.retroInst
        retrofit.sendSignInCode(email, otp).enqueue(object : Callback<SuccessToken> {
            override fun onResponse(call: Call<SuccessToken>, response: Response<SuccessToken>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        onSuccessResponse(it.token)
                    }
                } else {
                    Log.d("Error", "Fail request")
                }
            }

            override fun onFailure(call: Call<SuccessToken>, t: Throwable) {
                Log.d("error", t.localizedMessage.toString())
            }
        })
    }

    private fun onSuccessResponse(token: String) {
        sharedPreferences.edit().putString("token", token).apply()
        val intent = Intent(this, PasswordActivity::class.java)
        startActivity(intent)
    }

    private fun onInputCodeListener() {
        binding.otpView.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(otp: String) {
                sendOtp(email, otp)
            }
        }
    }
}