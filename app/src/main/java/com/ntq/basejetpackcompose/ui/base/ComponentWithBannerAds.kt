package com.ntq.basejetpackcompose.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> ComponentWithBannerAds(viewModel: BaseViewModel<T>,
                               content: @Composable () -> Unit) {
    Column {
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)) {
            content()
        }
        viewModel.adsManager.BannerAdsComponent()
    }
}