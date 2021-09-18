package com.rapidlearner.goodworklabstask.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rapidlearner.goodworklabstask.databinding.InflateRowPostViewBinding
import com.rapidlearner.goodworklabstask.model.Data

class PostRecyclerViewAdapter(private val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var postList:List<Data>? = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val binding = InflateRowPostViewBinding.inflate(LayoutInflater.from(context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val itemData = postList?.get(position)
       when(holder){
           is PostViewHolder->{
               holder.bind(itemData)
           }
       }
    }

    override fun getItemCount(): Int {
        return postList?.size?:0
    }

    fun notifyData(list: List<Data>){
        this.postList = list
        notifyDataSetChanged()
    }
}