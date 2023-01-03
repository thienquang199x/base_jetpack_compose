package com.ntq.basejetpackcompose.di

import com.ntq.basejetpackcompose.core.manager.ads_manager.AdsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAdsManager(): AdsManager = AdsManager()
}