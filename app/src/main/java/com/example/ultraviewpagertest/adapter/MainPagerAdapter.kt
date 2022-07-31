package com.example.ultraviewpagertest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ultraviewpagertest.MainTabFragment

class MainPagerAdapter(fm: FragmentManager, private val items: List<Fragment>): FragmentPagerAdapter(fm) {

    companion object {
        private const val PAGE_COUNT = 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "main${position+1}"
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

}