package com.example.aquarium

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aquarium.animal.ListOfAnimals
import com.example.aquarium.databinding.ActivityMainBinding
import com.example.aquarium.pager_adapter.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager2 = binding.viewPager2
        viewPager2.adapter = PagerAdapter(ListOfAnimals)

        TabLayoutMediator(binding.tabLayout, viewPager2) { tab, position ->
            tab.text = ListOfAnimals[position].name
        }. attach()

    }
}

