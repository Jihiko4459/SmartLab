package com.example.smartlab

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

const val TABLE = "TABLE"
class ActivityOnboard : AppCompatActivity() {
    var skip: SharedPreferences?=null
    lateinit var tl:TabLayout
    lateinit var vp:ViewPager2
    private val falist = listOf(Onboard1(), Onboard2(), Onboard3())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        tl=findViewById(R.id.tabLayout)
        vp=findViewById(R.id.viewPager)
        skip=getSharedPreferences(TABLE, MODE_PRIVATE)
        val adapter=viewadapter(this, falist)
        vp.adapter=adapter
        TabLayoutMediator(tl, vp){
            tab, pos ->
        }.attach()

    }

    private fun savestate(i:Int){
        val editor=skip?.edit()
        editor?.putInt("button_state", i)
        editor?.apply()
    }
    fun miss1(view: View) {

        val intent= Intent(this@ActivityOnboard, RegandLogActivity::class.java)
        startActivity(intent)
        var i = 1
        savestate(i)
    }
    fun miss2(view: View) {
        val intent= Intent(this@ActivityOnboard, RegandLogActivity::class.java)
        startActivity(intent)
        var i = 1
        savestate(i)
    }
    fun complete(view: View) {
        val intent= Intent(this@ActivityOnboard, RegandLogActivity::class.java)
        startActivity(intent)
        var i = 1
        savestate(i)
    }


}