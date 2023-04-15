package com.example.smartlab

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
    }

    fun pdf(view: View) {
        val url = "https://medic.madskill.ru/avatar/prav.pdf"
        val i = Intent(Intent.ACTION_VIEW)
        i.setData(Uri.parse(url))
        startActivity(i)
    }

    fun backHome(view: View) {
        val intent=Intent(this@FinishActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}