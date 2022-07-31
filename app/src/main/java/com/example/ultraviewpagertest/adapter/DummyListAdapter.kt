package com.example.ultraviewpagertest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ultraviewpagertest.databinding.ItemRecyclerViewBinding
import com.example.ultraviewpagertest.model.DummyItem

class DummyListAdapter: ListAdapter<DummyItem, RecyclerView.ViewHolder>(diffUtil) {

    private val vpState = HashMap<Int, Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DummyListItemViewHolder(
            ItemRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_NORMAL
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_NORMAL -> (holder as DummyListItemViewHolder).bind(getItem(position))
        }
    }

    companion object {
        private const val VIEW_TYPE_NORMAL = 100
        private const val VIEW_TYPE_BANNER = 101
        private const val VIEW_TYPE_MORE = 102

        private val diffUtil = object: DiffUtil.ItemCallback<DummyItem>() {
            override fun areItemsTheSame(oldItem: DummyItem, newItem: DummyItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DummyItem, newItem: DummyItem): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }

}

class DummyListItemViewHolder(private val binding: ItemRecyclerViewBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DummyItem) {
        binding.tvTitle.text = item.title
    }
}