package com.mvvmwithhilt.module.homeScreen

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.mvvmwithhilt.R
import com.mvvmwithhilt.common.BaseActivity
import com.mvvmwithhilt.databinding.ActivityHomeScreenBinding
import com.mvvmwithhilt.module.dto.DataClass
import com.mvvmwithhilt.module.homeScreen.adapter.HomeScreenListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreenActivity : BaseActivity<ActivityHomeScreenBinding, HomeScreenViewModel>() {

    private lateinit var homeScreeListAdapter: HomeScreenListAdapter
    private var dataClass = ArrayList<DataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.viewModel = viewModel

        dataBinding.homeList.layoutManager = GridLayoutManager(this, 1)
        homeScreeListAdapter = HomeScreenListAdapter(this, dataClass)
        dataBinding.homeList.adapter = homeScreeListAdapter
        viewModel.getHomeScreenData()
    }

    override fun getBindingViewId() = R.layout.activity_home_screen

    override fun getViewModelClass() = HomeScreenViewModel::class.java

    override fun setupObservable() {
        super.setupObservable()
        viewModel.componentList.observe(this) {
            dataClass = it
            homeScreeListAdapter.notifyHomeList(dataClass)
        }
    }
}