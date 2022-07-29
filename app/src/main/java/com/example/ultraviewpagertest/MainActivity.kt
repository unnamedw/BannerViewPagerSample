package com.example.ultraviewpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ultraviewpagertest.adapter.BannerPagerAdapter
import com.example.ultraviewpagertest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tmall.ultraviewpager.UltraViewPager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = mainPagerAdapter

//        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
//            tab.text = "${position+1}PAGE"
//        }.attach()

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("PAGE1"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("PAGE2"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("PAGE3"))

        binding.viewPager.setOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { position ->
                    binding.viewPager.currentItem = position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }

}

class MainPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        private const val PAGE_COUNT = 3
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        return MainTabFragment.newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "PAGE$position"
    }

}