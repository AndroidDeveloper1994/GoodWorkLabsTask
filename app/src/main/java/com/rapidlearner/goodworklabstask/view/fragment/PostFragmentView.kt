package com.rapidlearner.goodworklabstask.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rapidlearner.goodworklabstask.databinding.FragmentPostViewBinding
import com.rapidlearner.goodworklabstask.model.Data
import com.rapidlearner.goodworklabstask.network.cororutineHelper.Status
import com.rapidlearner.goodworklabstask.view.adapter.PostRecyclerViewAdapter
import com.rapidlearner.goodworklabstask.viewModel.PostViewModel
import com.rapidlearner.goodworklabstask.viewModelFactory.ViewModelFactory

class PostFragmentView : BaseFragment() {
    private var binding:FragmentPostViewBinding? = null
    private lateinit var postViewModel: PostViewModel
    private lateinit var postRecyclerViewAdapter: PostRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        loadData()
        getObserver()
        postRecyclerViewAdapter = PostRecyclerViewAdapter(activity as AppCompatActivity)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentPostViewBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(activity)
        binding?.recyclerView?.adapter = postRecyclerViewAdapter
    }

    private fun setUpViewModel(){
        val factory = ViewModelFactory(PostViewModel(apiClient))
        postViewModel = ViewModelProvider(activity as AppCompatActivity,factory).get(PostViewModel::class.java)
    }

    private fun loadData(){
        postViewModel.loadPostData()
    }

    private fun getObserver(){
        postViewModel.getPostData().observe(this, Observer {
            when(it.status){

                Status.LOADING->{
                    binding?.progressBar?.visibility = View.VISIBLE
                }

                Status.SUCCESS->{
                    binding?.progressBar?.visibility = View.GONE
                    it.data?.data?.let {
                        populatePostList(it)
                    }
                }

                Status.ERROR->{
                    binding?.progressBar?.visibility = View.GONE
                }
            }
        })
    }

    private fun populatePostList(list: List<Data>) {
        postRecyclerViewAdapter.notifyData(list)
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}