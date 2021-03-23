package com.mvvmwithhilt.di

import com.mvvmwithhilt.services.HomeScreenService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideHomeScreenService(retrofit: Retrofit) = retrofit.create<HomeScreenService>()

}