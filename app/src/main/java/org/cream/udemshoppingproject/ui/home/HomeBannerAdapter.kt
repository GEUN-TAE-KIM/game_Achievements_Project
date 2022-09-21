package org.cream.udemshoppingproject.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.cream.udemshoppingproject.Banner
import org.cream.udemshoppingproject.GlideApp
import org.cream.udemshoppingproject.R
import org.cream.udemshoppingproject.databinding.ItemHomeBannerBinding
import org.cream.udemshoppingproject.ui.common.loadImage
import java.text.DecimalFormat
import kotlin.math.roundToInt

// ListAdapter 는 레이아웃이 변경됨에따라 해당 데이터를 리스트로 0부터~ 해서 나열해주는 방식인 어뎁터
class HomeBannerAdapter : ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(
    BannerDiffCallback()) {

    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {

        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeBannerViewHolder(binding)

    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // 뷰에 대한 참조를해서 나타내는 것
    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(banner: Banner) {
            binding.banner = banner
            binding.executePendingBindings()
        }
    }
}

class BannerDiffCallback: DiffUtil.ItemCallback<Banner>() {

    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}
















