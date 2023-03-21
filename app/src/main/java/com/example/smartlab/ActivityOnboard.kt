package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ActivityOnboard : AppCompatActivity() {
    lateinit var tl:TabLayout
    lateinit var vp:ViewPager2
    private val falist = listOf(Onboard1(), Onboard2(), Onboard3())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        tl=findViewById(R.id.tabLayout)
        vp=findViewById(R.id.viewPager)
        val adapter=viewadapter(this, falist)
        vp.adapter=adapter
        TabLayoutMediator(tl, vp){
            tab, pos ->
        }.attach()

    }
    fun miss1(view: View) {
        val intent= Intent(this@ActivityOnboard, RegandLogActivity::class.java)
        startActivity(intent)
    }
    fun miss2(view: View) {
        val intent= Intent(this@ActivityOnboard, RegandLogActivity::class.java)
        startActivity(intent)
    }
    fun complete(view: View) {
        val intent= Intent(this@ActivityOnboard, RegandLogActivity::class.java)
        startActivity(intent)
    }
}