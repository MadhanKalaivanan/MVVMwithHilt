package com.mvvmwithhilt.module.homeScreen

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mvvmwithhilt.common.BaseViewModel
import com.mvvmwithhilt.module.dto.DataClass
import com.mvvmwithhilt.repository.HomeScreenRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch


class HomeScreenViewModel @ViewModelInject constructor(
    private val homeScreenRepository: HomeScreenRepository,
    @ApplicationContext private val context: Context
) : BaseViewModel() {

    var componentList = MutableLiveData<ArrayList<DataClass>>()
    var noRecordFound = MutableLiveData<Boolean>()

    fun getHomeScreenData() {

        viewModelScope.launch {

            isBusy.value = true
            val result = homeScreenRepository.getHomeScreenData()
            isBusy.value = false

            result.onSuccess {
                componentList.value = it
                noRecordFound.value = componentList.value!!.size == 0
            }
            result.onFailure { exception ->
                exception.localizedMessage?.let {
                    showToast(it)
                }
            }
        }
    }
}