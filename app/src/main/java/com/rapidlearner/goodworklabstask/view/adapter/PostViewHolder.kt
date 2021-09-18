package com.rapidlearner.goodworklabstask.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.rapidlearner.goodworklabstask.databinding.InflateRowPostViewBinding
import com.rapidlearner.goodworklabstask.model.Data

class PostViewHolder(binding: InflateRowPostViewBinding) : RecyclerView.ViewHolder(binding.root) {
  private val binding:InflateRowPostViewBinding = binding

    fun bind(itemData: Data?) {
      binding.tvTitle.text = itemData?.title
      binding.tvBody.text = itemData?.body
    }
}