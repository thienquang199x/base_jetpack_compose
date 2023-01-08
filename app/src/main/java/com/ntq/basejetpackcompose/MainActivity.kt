package com.ntq.basejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.integration.NodeHost
import com.bumble.appyx.core.integrationpoint.NodeComponentActivity
import com.ntq.basejetpackcompose.core.manager.app_manager.AppManager
import com.ntq.basejetpackcompose.ui.root.RootNode
import com.ntq.basejetpackcompose.ui.root.RootNodeImpl
import com.ntq.basejetpackcompose.ui.theme.BaseJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: NodeComponentActivity() {

    @Inject
    lateinit var appManager: AppManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NodeHost(integrationPoint = appyxIntegrationPoint){
                        RootNodeImpl(it, appManager = appManager)
                    }
                }
            }
        }
    }
}