package com.example.ultraviewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ultraviewpagertest.databinding.FragmentMainTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainTabFragment: Fragment() {

    private lateinit var binding: FragmentMainTabBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainTabBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val subPagerAdapter = SubPagerAdapter(this)
        binding.subViewPager.adapter = subPagerAdapter

        TabLayoutMediator(binding.subTabLayout, binding.subViewPager) { tab, position ->
            tab.text = "sub${position}"
        }.attach()
    }


    companion object {
        @JvmStatic
        fun newInstance() = MainTabFragment()
    }
}

class SubPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {
        const val PAGE_COUNT = 4
    }

    override fun getItemCount(): Int {
        return PAGE_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return SubTabFragment.newInstance()
    }

}


