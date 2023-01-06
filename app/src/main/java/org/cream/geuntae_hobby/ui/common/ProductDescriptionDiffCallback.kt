package org.cream.geuntae_hobby.ui.common

import androidx.recyclerview.widget.DiffUtil
import org.cream.geuntae_hobby.model.Description

class ProductDescriptionDiffCallback : DiffUtil.ItemCallback<Description>() {
    override fun areItemsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem == newItem
    }
}