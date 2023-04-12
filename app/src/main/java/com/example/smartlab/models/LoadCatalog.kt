package com.example.smartlab.models

import com.google.gson.annotations.SerializedName

data class LoadCatalog(
    val id : Int,
    val name : String,
    val description : String,
    val price : String,
    val category : String,
    @SerializedName("time_result")
    val time : String,
    val preparation : String,
    val bio : String
)
