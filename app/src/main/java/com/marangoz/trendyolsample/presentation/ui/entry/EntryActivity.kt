package com.marangoz.trendyolsample.presentation.ui.entry

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.DynamicColors
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.presentation.ui.mainpage.MainActivity


class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                startActivity(Intent(this@EntryActivity, MainActivity::class.java))
                finish()
            }
        }.start()
    }
}