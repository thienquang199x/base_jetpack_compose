package com.ntq.basejetpackcompose.ui.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ntq.basejetpackcompose.ui.base.AppComposable
import com.ntq.basejetpackcompose.ui.base.ComponentWithBannerAds
import com.ntq.basejetpackcompose.ui.base.BaseViewModel
import com.ntq.basejetpackcompose.ui.theme.AppDimens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeNode(buildContext: BuildContext) : Node(buildContext){

    @Composable
    override fun View(modifier: Modifier) {
        HomePage()
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun HomePage(viewModel: HomeViewModel = hiltViewModel()) {
        val state = viewModel.state.collectAsState()
        viewModel.init()

        val scaffoldState = rememberScaffoldState()
        val pagerState = rememberPagerState()
        val scope = rememberCoroutineScope()

        AppComposable(viewModel = viewModel) {
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar {
                        IconButton(onClick = {
                            viewModel.openMenu()
                        }) {
                            Text(text = "Go")
                        }
                    }
                },
                bottomBar = {
                    BottomNavigationBar(
                        items = listOf(Icons.Default.Home, Icons.Default.Menu, Icons.Default.Call),
                        pagerState = pagerState,
                        scope = scope
                    )
                },
            ) {
                Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
                    ComponentWithBannerAds(viewModel = viewModel as BaseViewModel<HomeState>) {
                        HorizontalPager(state = pagerState, count = 3, userScrollEnabled = false) { page ->
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(AppDimens.radius12.dp))
                                    .background(color = Color.Green), contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = page.toString(), style = TextStyle(
                                        fontSize = 50.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun BottomNavigationBar(items: List<ImageVector>, pagerState: PagerState, scope: CoroutineScope) {
        BottomAppBar(
            backgroundColor = Color.Cyan,
            elevation = 0.dp
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                backgroundColor = Color.Transparent,
                modifier = Modifier.fillMaxSize(),
                divider = {},
                indicator = {}) {
                items.forEachIndexed { index, s ->
                    IconButton(onClick = {
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }) {
                        Icon(
                            imageVector = s,
                            contentDescription = null,
                            tint = if (pagerState.currentPage == index) Color.Blue else Color.Black
                        )
                    }
                }
            }
        }
    }
}