package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import kotlin.math.floor
import kotlin.math.roundToInt

class PayActivity : AppCompatActivity() {
    //var status: String = "Связываемся с банком..."
    lateinit var textChange : TextView
    var secondsLeft = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        textChange = findViewById(/* id = */ R.id.pay_text)

        val timer = object : CountDownTimer(5000, 1000) {
            override fun onTick(ms: Long) {
                secondsLeft = floor((ms.toFloat() / 1000.0)).roundToInt()
                if (secondsLeft == 2) {
                    // Log.d("TIMER_OK", "timer is ok")
                    textChange.text = "Производим оплату..."
                }
            }


            override fun onFinish() {
                val intent = Intent(this@PayActivity, FinishActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }


}