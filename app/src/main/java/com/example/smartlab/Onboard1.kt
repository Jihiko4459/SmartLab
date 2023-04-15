package com.example.smartlab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog


class Onboard1 : Fragment() {
    private lateinit var textLink : TextView
    private lateinit var dialog : BottomSheetDialog
    private lateinit var mProgressBar: ProgressBar
    var count : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_onboard1, container, false)
        textLink = root.findViewById(R.id.name)
        mProgressBar = root.findViewById(R.id.progressBar)
        mProgressBar.visibility = ProgressBar.VISIBLE

        // обрабатывается нажатие
        textLink.setOnClickListener{
            showBottomSheet()
        }





        return root
    }
    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheeeet, null)
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        dialog.show()
    }




}