package com.ntq.basejetpackcompose.ui.component.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.ntq.basejetpackcompose.ui.base.ComponentWithBannerAds
import com.ntq.basejetpackcompose.ui.component.home.HomeViewModel

class MenuNode(buildContext: BuildContext): Node(buildContext) {
    @Composable
    override fun View(modifier: Modifier) {
        MenuPage()
    }

    @Composable
    fun MenuPage(viewModel: HomeViewModel = hiltViewModel()){
        ComponentWithBannerAds(viewModel = viewModel) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)) {
                viewModel.adsManager.NativeAdComponent()
            }
        }
    }
}