package com.example.smartlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.smartlab.databinding.ActivityCreateBinding
import com.example.smartlab.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var bind: FragmentProfileBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val gender=resources.getStringArray(R.array.gender)
        val arrayAdapter=ArrayAdapter(requireContext(), R.layout.dropdown_item, gender)
        bind?.autoCompleteTextView3?.setAdapter(arrayAdapter)

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}