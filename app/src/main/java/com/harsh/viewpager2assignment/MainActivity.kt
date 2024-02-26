package com.harsh.viewpager2assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
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

        var dotsRecycler = DotsRecycler(activityList.size)
        binding.viewPager.adapter = ViewPagerAdapter(activityList)
        binding.ivArrow.setOnClickListener {
            val currentPosition = binding.viewPager.currentItem
            if (currentPosition < activityList.size - 1) {
                binding.viewPager.currentItem = currentPosition + 1
            }
        }
        binding.tvSkip.setOnClickListener {
            val lastPosition = activityList.size - 1
            binding.viewPager.currentItem = lastPosition
        }
        binding.viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                dotsRecycler.updatePosition(position)
            }
        })
        binding.rvRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvRecycler.adapter = dotsRecycler

    }
}