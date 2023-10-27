package com.rustam.testgif.presentation.main

import android.os.Bundle
import androidx.navigation.findNavController
import com.rustam.testgif.R
import com.rustam.testgif.databinding.ActivityMainBinding
import com.rustam.testgif.presentation.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
    }
}