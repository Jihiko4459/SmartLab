package com.example.smartlab.api

import com.example.smartlab.models.SendEmail
import com.example.smartlab.models.SuccessEmail
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitRequest {
    @POST(/* value = */ "sendCode")
    fun sendEmailOtp(@Header("email") email: String): Call<SuccessEmail>

}