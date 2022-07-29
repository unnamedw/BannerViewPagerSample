package com.example.ultraviewpagertest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ultraviewpagertest.adapter.BannerPagerAdapter
import com.example.ultraviewpagertest.databinding.FragmentMainTabBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.tmall.ultraviewpager.UltraViewPager

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

    private val pageList = mutableListOf<Fragment>()
    private lateinit var subPagerAdapter: SubPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subPagerAdapter = SubPagerAdapter(fragment = this, pageList)

        binding.subViewPager.adapter = subPagerAdapter

        pageList.add(SubTabFragment())
        pageList.add(SubTabFragment())
        pageList.add(SubTabFragment())
        pageList.add(SubTabFragment())
        pageList.add(SubTabFragment())
        subPagerAdapter.notifyItemRangeChanged(0, pageList.size)

        TabLayoutMediator(binding.subTabLayout, binding.subViewPager) { tab, position ->
            tab.text = "sub${position}"
        }.attach()

        //init banner
//        binding.headerBanner.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL)
//        binding.headerBanner.adapter = BannerPagerAdapter(parentFragmentManager)

    }

    fun checkHeight(view: View) {
        view.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                Log.d("log_test", "${view.javaClass.simpleName} height >> ${view.height} [${pxToDp(requireContext(), view.height)}]")


                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }

        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainTabFragment()
    }
}

class SubPagerAdapter(fragment: Fragment, private val pages: List<Fragment>) : FragmentStateAdapter(fragment) {

    companion object {
        const val PAGE_COUNT = 4
    }

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return pages[position]
    }

}


