package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButton

class OrderRegActivity : AppCompatActivity() {
    lateinit var addres:EditText
    lateinit var date:EditText
    lateinit var patient:AutoCompleteTextView
    lateinit var phone:EditText
    lateinit var button:MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_reg)
        addres=findViewById(R.id.editTextText)
        date=findViewById(R.id.editTextText2)
        patient=findViewById(R.id.autoCompleteTextView)
        phone=findViewById(R.id.editTextText3)
        button=findViewById(R.id.button22)

        phone.addTextChangedListener {
                text ->
            if (addres.text.toString().isNotEmpty()&&date.text.toString().isNotEmpty()&&patient.text.toString().isNotEmpty()&&phone.text.toString().isNotEmpty()){
                button.isEnabled=true
            }
        }
    }

    fun order(view: View) {
        val intent= Intent(this@OrderRegActivity, PayActivity::class.java)
        startActivity(intent)
    }

}