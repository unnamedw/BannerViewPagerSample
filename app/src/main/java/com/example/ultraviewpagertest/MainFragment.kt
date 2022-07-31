package com.example.ultraviewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.ultraviewpagertest.adapter.MainPagerAdapter
import com.example.ultraviewpagertest.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainPageList = mutableListOf<Fragment>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mainPagerAdapter = MainPagerAdapter(parentFragmentManager, mainPageList)
        binding.mainViewPager.adapter = mainPagerAdapter
        binding.mainTabLayout.setupWithViewPager(binding.mainViewPager)
        binding.mainViewPager.setOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                binding.mainViewPager.setPageTransformer(false) { page, position ->
                    updatePagerHeightForChild(page, binding.mainViewPager)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        initPage()
    }

    private fun updatePagerHeightForChild(view: View, pager: ViewPager) {
        view.post {
            val wMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY)
            val hMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            view.measure(wMeasureSpec, hMeasureSpec)
            pager.layoutParams = (pager.layoutParams).also { lp -> lp.height = view.measuredHeight }
            pager.invalidate()
        }
    }

    private fun initPage() {
        mainPageList.add(MainTabFragment.newInstance())
        mainPageList.add(MainTabFragment.newInstance())
        binding.mainViewPager.adapter?.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

}