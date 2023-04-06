package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.addTextChangedListener
import com.example.smartlab.databinding.ActivityCreateBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class CreateActivity : AppCompatActivity() {
    private lateinit var bind:ActivityCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind=ActivityCreateBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val gender =resources.getStringArray(R.array.gender)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, gender)
        bind.autoCompleteTextView2.setAdapter((arrayAdapter))
        bind.editTextTextPersonName.addTextChangedListener { text ->
            if (text.toString().length>0){
                bind.button.isEnabled = true
                bind.editTextTextPersonName.setBackgroundResource(R.drawable.selected_input_session2)
            }else{
                bind.button.isEnabled = false
                bind.editTextTextPersonName.setBackgroundResource(R.drawable.selected_input)
            }
        }
        bind.editTextTextPersonName2.addTextChangedListener { text ->
            if (text.toString().length>0){
                bind.button.isEnabled = true
                bind.editTextTextPersonName2.setBackgroundResource(R.drawable.selected_input_session2)
            }else{
                bind.button.isEnabled = false
                bind.editTextTextPersonName2.setBackgroundResource(R.drawable.selected_input)
            }
        }
        bind.editTextTextPersonName3.addTextChangedListener { text ->
            if (text.toString().length>0){
                bind.button.isEnabled = true
                bind.editTextTextPersonName3.setBackgroundResource(R.drawable.selected_input_session2)
            }else{
                bind.button.isEnabled = false
                bind.editTextTextPersonName3.setBackgroundResource(R.drawable.selected_input)
            }
        }
        bind.editTextTextPersonName4.addTextChangedListener { text ->
            if (text.toString().length>0){
                bind.button.isEnabled = true
                bind.editTextTextPersonName4.setBackgroundResource(R.drawable.selected_input_session2)
            }else{
                bind.button.isEnabled = false
                bind.editTextTextPersonName4.setBackgroundResource(R.drawable.selected_input)
            }
        }
    }

    fun miss4(view: View) {
        val intent = Intent(this@CreateActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    fun create(view: View) {
        val intent = Intent(this@CreateActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}