package com.ntq.basejetpackcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ntq.basejetpackcompose.core.manager.ads_manager.AdsManager
import com.ntq.basejetpackcompose.core.manager.ads_manager.model.AdConfig
import com.ntq.basejetpackcompose.ui.component.home.HomeScreen
import com.ntq.basejetpackcompose.ui.theme.BaseJetpackComposeTheme
import com.ntq.basejetpackcompose.utils.NavDestinations
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavDestinations.HOME_SCREEN){
                        composable(NavDestinations.HOME_SCREEN){
                            HomeScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}