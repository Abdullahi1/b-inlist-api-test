package com.example.data.di

import com.example.data.cardInfo.CardInfoRepositoryImpl
import com.example.domain.cardInfo.CardInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindCardInfoRepository(impl: CardInfoRepositoryImpl): CardInfoRepository
}