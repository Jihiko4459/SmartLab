package com.example.smartlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.example.smartlab.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var bind: FragmentProfileBinding
    private val binding get() = bind!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentProfileBinding.inflate(inflater, container, false)

        val gender=resources.getStringArray(R.array.gender)
        val arrayAdapter=ArrayAdapter(requireContext(), R.layout.dropdown_item, gender)
        bind.autoCompleteTextView3.setAdapter(arrayAdapter)
        bind.editTextTextPersonName.addTextChangedListener{ text ->
                bind.button.isEnabled=true
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }



}