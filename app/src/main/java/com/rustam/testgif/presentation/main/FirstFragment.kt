package com.rustam.testgif.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        val gifAdapter = GifAdapter().apply {
            itemClickListener = {
                openGif(url = it.originalUrl)
            }
        }

        binding.gifsRecyclerView.apply {
            layoutManager = GridLayoutManager(view.context, 3)
            adapter = gifAdapter
        }

        viewModel.gifsFlow.collectWithLifecycleState { gifs ->
            gifAdapter.gifs = gifs
        }

        viewModel.updateGifs()

    }


    private fun openGif(url: String) {
        val gifId = "https://media.giphy.com/media/yvBI03Km1DyIHvL7v5/giphy.gif"
        val direction = FirstFragmentDirections.actionFirstFragmentToSecondFragment(url)
        findNavController().navigate(direction)
    }
}