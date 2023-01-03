package com.ntq.basejetpackcompose.core.manager.ads_manager

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.*
import com.ntq.basejetpackcompose.core.manager.ads_manager.model.AdConfig
import com.ntq.basejetpackcompose.extension.screenSize

class AdsManager {

    private var adConfig:AdConfig? = null

    fun initialize(context: Context, testDeviceIds:List<String> = emptyList(), adConfig: AdConfig){
        MobileAds.initialize(context)
        val requestConfiguration = RequestConfiguration.Builder().apply {
            setTestDeviceIds(testDeviceIds)
        }.build()
        MobileAds.setRequestConfiguration(requestConfiguration)
        this.adConfig = adConfig
    }

    @Composable
    fun BannerAdsView(){
        if (adConfig?.bannerAdId == null){
            Spacer(modifier = Modifier.size(0.dp))
        } else {
            AndroidView(
                modifier = Modifier
                    .fillMaxWidth(),
                factory = { context ->
                    AdView(context).apply {
                        setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, context.screenSize().width.toInt()))
                        // Add your adUnitID, this is for testing.
                        adUnitId = adConfig!!.bannerAdId!!
                        loadAd(AdRequest.Builder().build())
                    }
                }
            )
        }
    }
}