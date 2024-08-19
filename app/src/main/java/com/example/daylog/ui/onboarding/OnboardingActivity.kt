package com.example.daylog.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.daylog.MainActivity
import com.example.daylog.R
import com.example.daylog.ui.adapters.ViewPagerAdapter
import me.relex.circleindicator.CircleIndicator3

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        val adapter = ViewPagerAdapter(this)
//        val btn_next_last = findViewById<Button>(R.id.btn_onboard3)

        viewPager.adapter = adapter
        indicator.setViewPager(viewPager)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == adapter.itemCount - 1) {

//                    val intent = Intent(this, MainActivity::class.java)
//                    btn_next_last.setOnClickListener(intent)
                }
            }
        })
    }
}