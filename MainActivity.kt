package com.example.aruuke_rakhmanova_hw_5_3m

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var count = 0
    private val maxCount = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter_tv = findViewById<TextView>(R.id.counter_tv)
        val counter_btn = findViewById<Button>(R.id.counter_btn)

        counter_btn.setOnClickListener {
            if (count < maxCount && counter_btn.text == "+1") {
                count++
            } else if (count > 0 && counter_btn.text == "-1") {
                count--
            }

            counter_tv.text = count.toString()

            if (count == maxCount) counter_btn.text = "-1"
            else if (count == 0) {
                openSecondFragment()
            }
        }
    }

    private fun openSecondFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, SecondFragment())
        transaction.commit()
    }
}