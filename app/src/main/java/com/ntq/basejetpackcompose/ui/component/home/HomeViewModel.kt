package com.ntq.basejetpackcompose.ui.component.home

import android.os.Handler
import android.os.Looper
import com.ntq.basejetpackcompose.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject

enum class PageStatus{
    LOADING,
    IDLE,
    ERROR
}

data class HomeState(val pageStatus: PageStatus = PageStatus.LOADING)

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState>(HomeState()) {

    fun init(){
        Handler(Looper.getMainLooper()).postDelayed({
            internalState.value = internalState.value.copy(pageStatus = PageStatus.IDLE)
        }, TimeUnit.SECONDS.toMillis(5))
    }
}