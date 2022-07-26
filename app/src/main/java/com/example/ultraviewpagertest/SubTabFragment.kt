package com.example.ultraviewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ultraviewpagertest.databinding.*
import com.example.ultraviewpagertest.model.BannerItem
import com.example.ultraviewpagertest.model.DummyItem
import java.util.*
import kotlin.collections.HashMap

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
//        return when (viewType) {
//            VIEW_TYPE_BANNER -> DummyListBannerViewHolder(
//                ItemRecyclerBannerBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
//            VIEW_TYPE_MORE -> DummyListMoreViewHolder(
//                ItemRecyclerMoreBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
//            else -> DummyListItemViewHolder(
//                ItemRecyclerViewBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
//        }

    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_NORMAL

//        return when(position) {
//            currentList.lastIndex -> VIEW_TYPE_MORE
//            currentList.lastIndex-1 -> VIEW_TYPE_BANNER
//            else -> VIEW_TYPE_NORMAL
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_NORMAL -> (holder as DummyListItemViewHolder).bind(getItem(position))
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {

        super.onViewRecycled(holder)
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

class BannerPagerAdapter: RecyclerView.Adapter<BannerPagerAdapter.BannerViewHolder>() {

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

    class BannerViewHolder(binding: ItemBannerBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BannerItem) {

        }
    }

}

class DummyListBannerViewHolder(binding: ItemRecyclerBannerBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DummyItem) {}
}

class DummyListMoreViewHolder(binding: ItemRecyclerMoreBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DummyItem) {}
}