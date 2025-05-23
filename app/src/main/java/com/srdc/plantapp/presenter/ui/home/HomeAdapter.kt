package com.srdc.plantapp.presenter.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.plantapp.databinding.ItemCategoryBinding
import com.srdc.plantapp.data.local.database.CategoryEntity

class HomeAdapter : ListAdapter<CategoryEntity, HomeAdapter.CategoryViewHolder>(DiffCallback()) {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryEntity) {
//            binding.textName.text = item.name
//            Glide.with(binding.imageView.context)
//                .load(item.imageUrl)
//                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<CategoryEntity>() {
        override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity) = oldItem == newItem
    }
}
