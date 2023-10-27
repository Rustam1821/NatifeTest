package com.rustam.testgif.presentation.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rustam.testgif.R
import com.rustam.testgif.databinding.FragmentFirstBinding
import com.rustam.testgif.databinding.FragmentSecondBinding
import com.rustam.testgif.presentation.GifViewModel
import com.rustam.testgif.presentation.base.BaseFragment
import com.rustam.testgif.presentation.base.viewBinding

class SecondFragment : BaseFragment() {

    private val binding by viewBinding(FragmentSecondBinding::bind)

    private lateinit var viewModel: GifViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSecondBinding.inflate(inflater, container, false).root
    }

}