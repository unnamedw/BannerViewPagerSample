package com.example.ultraviewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ultraviewpagertest.databinding.FragmentBannerBinding

class BannerFragment: Fragment() {

    private lateinit var binding: FragmentBannerBinding

    private var color: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        color = arguments?.getInt(COLOR)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBannerBinding.inflate(layoutInflater, container, false)
        color?.let {
            binding.layoutBackground.setBackgroundColor(it)
        }

        return binding.root
    }

    companion object {
        private const val COLOR = "color"

        @JvmStatic
        fun newInstance(color: Int) = BannerFragment().apply {
            arguments?.apply {
                putInt(COLOR, color)
            }
        }
    }

}