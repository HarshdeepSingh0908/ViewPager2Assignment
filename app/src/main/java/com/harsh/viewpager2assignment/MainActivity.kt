package com.harsh.viewpager2assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harsh.viewpager2assignment.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val activityList : MutableList<Activities> = mutableListOf<Activities>()
        activityList.add(Activities(R.drawable.meditation,"Meditation"))
        activityList.add(Activities(R.drawable.tennis,"Tennis"))
        activityList.add(Activities(R.drawable.stretching,"Stretching"))
        activityList.add(Activities(R.drawable.baseall,"Baseball"))

        binding.viewPager2.adapter = ViewPagerAdapter(activityList)

    }
}