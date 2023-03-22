package com.example.smartlab.utils

import com.example.smartlab.api.RetrofitRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {
    fun createClien(): OkHttpClient.Builder {
        val logi = HttpLoggingInterceptor()
        logi.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(logi)
    }

    val retroInst = Retrofit.Builder()
        .baseUrl("https://medic.madskill.ru/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(createClien().build())
        .build()
        .create(RetrofitRequest::class.java)
}