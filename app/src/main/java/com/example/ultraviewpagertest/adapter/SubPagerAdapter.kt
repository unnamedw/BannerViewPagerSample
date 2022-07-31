package com.example.ultraviewpagertest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ultraviewpagertest.SubTabFragment

class SubPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    companion object {
        const val PAGE_COUNT = 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "sub${position+1}"
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        return SubTabFragment.newInstance()
    }

}