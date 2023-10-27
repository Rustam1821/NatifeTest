package com.rustam.testgif.presentation.main

import android.os.Bundle
import com.rustam.testgif.R
import com.rustam.testgif.presentation.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}