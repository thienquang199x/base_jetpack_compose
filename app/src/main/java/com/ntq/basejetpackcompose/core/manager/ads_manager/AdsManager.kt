package com.ntq.basejetpackcompose.core.manager.ads_manager

import android.content.Context
import android.view.LayoutInflater
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.*
import com.ntq.basejetpackcompose.R
import com.ntq.basejetpackcompose.core.manager.ads_manager.*
import com.ntq.basejetpackcompose.core.manager.ads_manager.model.AdConfig
import com.ntq.basejetpackcompose.core.manager.ads_manager.native.NativeTemplateStyle
import com.ntq.basejetpackcompose.core.manager.ads_manager.native.TemplateView
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
    fun BannerAdsComponent(){
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

    @Composable
    fun NativeAdComponent(){
        if (adConfig?.bannerAdId == null){
            Spacer(modifier = Modifier.size(0.dp))
        } else {
            AndroidView(
                modifier = Modifier
                    .fillMaxWidth(),
                factory = { context ->
                    val styles =
                        NativeTemplateStyle.Builder().build()
                    val view = LayoutInflater.from(context).inflate(R.layout.native_ad, null, false)
                    val template = view.findViewById<TemplateView>(R.id.my_template)
                    template.setStyles(styles)
                    view
                },
                update = {
                    val adLoader = AdLoader.Builder(it.context, adConfig!!.nativeAdId!!)
                        .forNativeAd { ad ->
                            val template = it.findViewById<TemplateView>(R.id.my_template)
                            template.setNativeAd(ad)
                        }
                        .withAdListener(object : AdListener() {
                            override fun onAdFailedToLoad(p0: LoadAdError) {
                                super.onAdFailedToLoad(p0)
                                println("QQQQQ ${p0.responseInfo}")
                            }
                        })
                        .build()
                    adLoader.loadAd(AdRequest.Builder().build())
                }
            )
        }
    }
}