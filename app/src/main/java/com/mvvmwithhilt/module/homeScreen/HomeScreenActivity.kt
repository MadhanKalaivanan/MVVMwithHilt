package com.mvvmwithhilt.module.homeScreen

import android.os.Bundle
import com.mvvmwithhilt.R
import com.mvvmwithhilt.common.BaseActivity
import com.mvvmwithhilt.databinding.ActivityHomeScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreenActivity : BaseActivity<ActivityHomeScreenBinding, HomeScreenViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.viewModel = viewModel

        viewModel.getHomeScreenData()
    }

    override fun getBindingViewId() = R.layout.activity_home_screen

    override fun getViewModelClass() = HomeScreenViewModel::class.java

    override fun setupObservable() {
        super.setupObservable()
        viewModel.componentList.observe(this) {

        }
    }
}