package com.ntq.basejetpackcompose.ui.base

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ntq.basejetpackcompose.utils.components.AppDialog
import com.ntq.basejetpackcompose.utils.components.AppLoadingComponent
import com.ntq.basejetpackcompose.utils.components.AppLoadingIndicator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun <T> AppComposable(
    viewModel: BaseViewModel<T>,
    content: @Composable () -> Unit
) {
    val event by viewModel.eventFlow.collectAsState()
    OnNewEvent(event, viewModel)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        content()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun <T> OnNewEvent(event: BaseEvent?, viewModel: BaseViewModel<T>){
    when(event){
        is MessageEvent -> {
            Dialog(onDismissRequest = {  }) {
                AppDialog(message = event.msg, onClick = {
                    viewModel.dismissDialog()
                })
            }
        }
        is ToastEvent -> {
            Toast.makeText(LocalContext.current.applicationContext, event.msg, Toast.LENGTH_LONG).show()
        }
        is LoadingEvent -> {
            if (event.isLoading){
                Dialog(onDismissRequest = {}, properties = DialogProperties(usePlatformDefaultWidth = false)) {
                    AppLoadingComponent()
                }
            }
        }
    }
}