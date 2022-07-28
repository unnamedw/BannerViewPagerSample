package com.example.ultraviewpagertest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
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

        binding.linearContainer.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                Log.d("log_test", "linearContainer height >> ${binding.linearContainer.height} [${pxToDp(requireContext(), binding.linearContainer.height)}]")

                binding.linearContainer.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }

        })



    }

    fun checkHeight(view: View) {
        view.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                Log.d("log_test", "${view.javaClass.simpleName} height >> ${view.height} [${pxToDp(requireContext(), view.height)}]")


                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }

        })
    }

    fun setUpViewPagerWithTab() {


//        binding.subTabLayout.addTab(binding.subTabLayout.newTab().setText("SUB1"))
//        binding.subTabLayout.addTab(binding.subTabLayout.newTab().setText("SUB2"))
//        binding.subTabLayout.addTab(binding.subTabLayout.newTab().setText("SUB3"))
//        binding.subTabLayout.addTab(binding.subTabLayout.newTab().setText("SUB4"))
//
//        binding.subViewPager.setOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.subTabLayout))
//        binding.subTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                tab?.position?.let { position ->
//                    binding.subViewPager.currentItem = position
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainTabFragment()
    }
}

//class SubPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
//
//    companion object {
//        const val PAGE_COUNT = 4
//    }
//
//    override fun getCount(): Int {
//        return PAGE_COUNT
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return SubTabFragment.newInstance()
//    }
//
//    override fun getPageTitle(position: Int): CharSequence {
//        return position.toString()
//    }
//
//}

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


