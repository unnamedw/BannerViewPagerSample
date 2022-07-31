package com.example.ultraviewpagertest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ultraviewpagertest.databinding.ItemBannerBinding
import com.example.ultraviewpagertest.model.BannerItem

class BannerPagerAdapter: RecyclerView.Adapter<BannerViewHolder>() {

    private var items: List<BannerItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun submitList(items: List<BannerItem>) {
        this.items = items
        notifyItemRangeChanged(0, items.size)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class BannerViewHolder(binding: ItemBannerBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BannerItem) {

    }
}