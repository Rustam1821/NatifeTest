package com.rustam.testgif.presentation.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rustam.testgif.R
import com.rustam.testgif.databinding.FragmentFirstBinding
import com.rustam.testgif.presentation.GifViewModel
import com.rustam.testgif.presentation.base.BaseFragment
import com.rustam.testgif.presentation.base.viewBinding

class FirstFragment : BaseFragment() {

    private val binding by viewBinding(FragmentFirstBinding::bind)

    private val viewModel: GifViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFirstBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gifsFlow.collectWithLifecycleState {gifs ->
            binding.textviewFirst.text = if (gifs.isEmpty()) {
                "Loading ..."
            } else {
                gifs[0].title
            }
        }

        viewModel.updateGifs()

        binding.buttonFirst.setOnClickListener {
            val gifId = "lallalal"
            val direction = FirstFragmentDirections.actionFirstFragmentToSecondFragment(gifId)
            viewModel.updateGifs()
            //findNavController().navigate(direction)

        }
    }

}