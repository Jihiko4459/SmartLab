package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.smartlab.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bind:ActivityHomeBinding
    private val falist = listOf(AnalizisFragment(), ResultFragment(), SupportFragment(), ProfileFragment())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bind.root)
        supportFragmentManager.beginTransaction().replace(R.id.framefr, falist[0]).commit()
        bind.navi.setOnItemSelectedListener {
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
    fun onCart(view: View) {
        val intent= Intent(this@HomeActivity, CartActivity::class.java)
        startActivity(intent)
    }
    fun save(view: View) {
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show()
    }

    fun vis(view: View) {
        Toast.makeText(this, "Заказ добавлен в корзину", Toast.LENGTH_LONG).show()
//        bind.line.isVisible=true
    }
}