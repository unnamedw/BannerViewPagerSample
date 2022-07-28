package com.example.ultraviewpagertest.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ultraviewpagertest.databinding.ActivityMainBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}