package org.cream.geuntae_hobby.ui.productdetail2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.cream.geuntae_hobby.databinding.ItemProductDescriptionBinding
import org.cream.geuntae_hobby.model.Description
import org.cream.geuntae_hobby.ui.common.ProductDescriptionDiffCallback

class ProductDetailAdapter2 :
    ListAdapter<Description, ProductDetailAdapter2.DescriptionViewHolder>(
        ProductDescriptionDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {
        val binding = ItemProductDescriptionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DescriptionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DescriptionViewHolder(private val binding: ItemProductDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(description: Description) {
            binding.imageUrl = description.detail
            binding.executePendingBindings()
        }
    }
}