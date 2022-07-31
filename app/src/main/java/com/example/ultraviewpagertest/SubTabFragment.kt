package com.example.ultraviewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ultraviewpagertest.adapter.DummyListAdapter
import com.example.ultraviewpagertest.databinding.*
import com.example.ultraviewpagertest.model.DummyItem
import java.util.*

class SubTabFragment: Fragment() {

    private lateinit var binding: FragmentSubTabBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubTabBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listAdapter = DummyListAdapter()
        binding.recyclerView.adapter = listAdapter

        val list: List<DummyItem> = List(20) {
            DummyItem(
                id = it,
                title = UUID.randomUUID().toString()
            )
        }

        listAdapter.submitList(list)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SubTabFragment()
    }
}


