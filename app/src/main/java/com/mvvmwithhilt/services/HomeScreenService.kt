package com.mvvmwithhilt.services

import com.mvvmwithhilt.common.Constants
import com.mvvmwithhilt.module.dto.HomeScreenListResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface HomeScreenService {
    @POST(Constants.GET_HOME_LIST)
    suspend fun getHomeList(@Query("category_id") categoryID: String): HomeScreenListResponse

}