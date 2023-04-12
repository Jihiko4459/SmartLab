package com.example.smartlab.api

import com.example.smartlab.models.*
import retrofit2.Call
import retrofit2.http.*

interface RetrofitRequest {
    @POST(/* value = */ "sendCode")
    fun sendEmailOtp(@Header("email") email: String): Call<SuccessEmail>

    @POST(/* value = */ "signin")
    fun sendSignInCode(@Header("email") email: String, @Header("code") code: String): Call<SuccessToken>

    @GET(/* value = */ "news")
    fun loadNewsSheet() : Call<LoadNews>
    @GET(/* value = */ "catalog")
    fun loadCatalogList() : Call<List<LoadCatalog>>

}