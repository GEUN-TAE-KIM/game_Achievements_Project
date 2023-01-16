package org.cream.geuntae_hobby.ui.myinfodetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.cream.geuntae_hobby.databinding.ItemMyinfodetailsBinding
import org.cream.geuntae_hobby.model.MyInfoDetails

class MyInfoDetailsAdapter(private val viewModel: MyInfoDetailsViewModel) :
    ListAdapter<MyInfoDetails, MyInfoDetailsAdapter.MyInfoDetailsViewHolder>(
        MyInfoDetailsDiffCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyInfoDetailsAdapter.MyInfoDetailsViewHolder {
        val binding =
            ItemMyinfodetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyInfoDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyInfoDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MyInfoDetailsViewHolder(private val binding: ItemMyinfodetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: MyInfoDetails) {
            binding.viewModel = viewModel
            binding.category = category
            binding.executePendingBindings()
        }
    }

}

class MyInfoDetailsDiffCallback : DiffUtil.ItemCallback<MyInfoDetails>() {
    override fun areItemsTheSame(oldItem: MyInfoDetails, newItem: MyInfoDetails): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: MyInfoDetails, newItem: MyInfoDetails): Boolean {
        return oldItem == newItem
    }
}