package com.example.apitest.di

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import com.example.apitest.network.ConnectivityRepositoryImpl
import com.example.domain.network.ConnectivityRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ConnectivityManagerModule {


    @Provides
    @Singleton
    fun providesConnectivityManager(@ApplicationContext context: Context): ConnectivityManager =
        context.getSystemService(Activity.CONNECTIVITY_SERVICE) as ConnectivityManager
}

@InstallIn(ActivityComponent::class)
@Module
abstract class ConnectivityModule {

    @Binds
    abstract fun bindConnectivityModule(impl: ConnectivityRepositoryImpl): ConnectivityRepository
}