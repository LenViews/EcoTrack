package com.ecotrack

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ecotrack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RecyclableViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupUI()
    }

    private fun setupUI() {
        binding.btnAddRecyclable.setOnClickListener {
            startActivity(Intent(this, AddRecyclable::class.java))
        }

        binding.btnViewStats.setOnClickListener {
            // For future stats screen
            // startActivity(Intent(this, StatsActivity::class.java))
        }
    }
}