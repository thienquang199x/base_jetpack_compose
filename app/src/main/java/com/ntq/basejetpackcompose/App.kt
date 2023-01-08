package com.ntq.basejetpackcompose

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.ntq.basejetpackcompose.core.manager.ads_manager.AdsManager
import com.ntq.basejetpackcompose.core.manager.ads_manager.model.AdConfig
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var adsManager: AdsManager

    override fun onCreate() {
        super.onCreate()

        adsManager.initialize(
            this,
            adConfig = AdConfig(
                bannerAdId = "ca-app-pub-3940256099942544/6300978111",
                nativeAdId = "ca-app-pub-3940256099942544/2247696110"
            ),
            testDeviceIds = mutableListOf("FA32582421E0336587C7BE0DCB63991A")
        )
    }
}