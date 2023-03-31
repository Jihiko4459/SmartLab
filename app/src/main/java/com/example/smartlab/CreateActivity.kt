package com.example.smartlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class CreateActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var lastname:EditText
    lateinit var patronimic:EditText
    lateinit var date_of_birth:EditText
    lateinit var button: MaterialButton
    lateinit var dropdown:TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        name=findViewById(R.id.editTextTextPersonName)
        lastname=findViewById(R.id.editTextTextPersonName2)
        patronimic=findViewById(R.id.editTextTextPersonName3)
        date_of_birth=findViewById(R.id.editTextTextPersonName4)
        button=findViewById(R.id.button)
        dropdown=findViewById(R.id.textInputLayout)
        val gender=resources.getStringArray(R.array.gender)
        //val arrayAdapter=ArrayAdapter(requireContext(), R.layout.dropdown_item, gender)
        name.addTextChangedListener { text ->
                if (text.toString().length > 0) {
                    button.isEnabled = true
                } else {
                    button.isEnabled = false
                }
            }
        lastname.addTextChangedListener { text ->
                if (text.toString().length > 0) {
                    button.isEnabled = true
                } else {
                    button.isEnabled = false
                }
            }
        patronimic.addTextChangedListener { text ->
            if (text.toString().length > 0) {
                button.isEnabled = true
            } else {
                button.isEnabled = false
            }
        }
        date_of_birth.addTextChangedListener { text ->
            if (text.toString().length > 0) {
                button.isEnabled = true
            } else {
                button.isEnabled = false
            }
        }
    }
}