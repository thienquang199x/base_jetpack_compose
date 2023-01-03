package com.ntq.basejetpackcompose.ui.component.home

import android.graphics.drawable.Icon
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
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ntq.basejetpackcompose.ui.base.AppWithAdsComposable
import com.ntq.basejetpackcompose.ui.base.BaseViewModel
import com.ntq.basejetpackcompose.ui.theme.AppDimens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    viewModel.init()

    if (state.pageStatus == PageStatus.LOADING){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        val scaffoldState = rememberScaffoldState()
        val pagerState = rememberPagerState()
        val scope = rememberCoroutineScope()

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {

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
                AppWithAdsComposable(viewModel = viewModel as BaseViewModel<HomeState>) {
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