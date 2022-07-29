package com.example.ultraviewpagertest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ultraviewpagertest.BannerFragment
import com.example.ultraviewpagertest.R

class BannerPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    companion object {
        const val BANNER_COUNT = 3
    }

    override fun getCount(): Int {
        return BANNER_COUNT
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BannerFragment.newInstance(R.color.purple_200)
            1 -> BannerFragment.newInstance(R.color.teal_200)
            else -> BannerFragment.newInstance(com.google.android.material.R.color.material_grey_600)
        }
    }
}