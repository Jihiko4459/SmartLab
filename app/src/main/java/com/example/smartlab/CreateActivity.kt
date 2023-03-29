package com.example.smartlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.textfield.TextInputLayout

class CreateActivity : AppCompatActivity() {
    lateinit var dropdown:TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        dropdown=findViewById(R.id.editTextTextPersonName4)
        val gender=resources.getStringArray(R.array.gender)
        //val arrayAdapter=ArrayAdapter(requireContext(), R.layout.dropdown_item, gender)

    }
}