package com.example.ultraviewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.ultraviewpagertest.adapter.SubPagerAdapter
import com.example.ultraviewpagertest.databinding.FragmentMainTabBinding

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
        val subPagerAdapter = SubPagerAdapter(parentFragmentManager)
        binding.subViewPager.adapter = subPagerAdapter

        binding.subTabLayout.setupWithViewPager(binding.subViewPager.viewPager)
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

    companion object {
        @JvmStatic
        fun newInstance() = MainTabFragment()
    }
}




