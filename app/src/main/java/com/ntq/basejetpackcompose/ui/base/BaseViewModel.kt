package com.ntq.basejetpackcompose.ui.base

import androidx.lifecycle.*
import com.ntq.basejetpackcompose.core.manager.ads_manager.AdsManager
import com.ntq.basejetpackcompose.ui.component.home.PageStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

open class BaseViewModel<T> @Inject constructor(private val initState:T) : LifecycleObserver, ViewModel() {

    @Inject
    lateinit var adsManager: AdsManager

    protected val internalState: MutableStateFlow<T> by lazy { MutableStateFlow(initState) }

    val state: StateFlow<T>
        get() = internalState

}