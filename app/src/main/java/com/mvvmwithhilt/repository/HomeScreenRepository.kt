package com.mvvmwithhilt.repository

import com.mvvmwithhilt.module.dto.DataClass
import com.mvvmwithhilt.services.HomeScreenService
import com.mvvmwithhilt.services.RemoteError
import com.mvvmwithhilt.utils.ConnectivityObserver
import com.mvvmwithhilt.utils.Result
import javax.inject.Inject

class HomeScreenRepository @Inject constructor(
    private val homeScreenService: HomeScreenService,
    private val connectivityObserver: ConnectivityObserver
) {

    suspend fun getHomeScreenData(): Result<ArrayList<DataClass>>{
        if (!connectivityObserver.isConnected) {
            return Result.Failure(RemoteError.networkUnAvailable)
        }
        try {
            val response = homeScreenService.getHomeList("2")
            response.components?.let {
                return Result.Success(it)
            }
            return Result.Failure(RemoteError.unknownError)
        } catch (e: Exception) {
            return Result.Failure(RemoteError.unknownError)
        }
    }

}