package com.example.smartlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.smartlab.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    lateinit var bn: BottomNavigationView
    private val falist = listOf(AnalizisFragment(), ResultFragment(), SupportFragment(), ProfileFragment())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bn=findViewById(R.id.navi)
        supportFragmentManager.beginTransaction().replace(R.id.framefr, falist[0]).commit()
        bn.setOnItemSelectedListener {
            when(it.itemId){
                R.id.analis->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, falist[0]).commit()
                }
                R.id.res->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, falist[1]).commit()
                }
                R.id.sup->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, falist[2]).commit()
                }
                R.id.us->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, falist[3]).commit()
                }
            }
            true
        }

    }
    fun save(view: View) {
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show()
    }
}