package com.ntq.basejetpackcompose.ui.base

import androidx.lifecycle.*
import com.ntq.basejetpackcompose.core.manager.ads_manager.AdsManager
import com.ntq.basejetpackcompose.core.manager.app_manager.AppManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

open class BaseViewModel<T> @Inject constructor(private val initState:T) : LifecycleObserver, ViewModel() {

    private val eventStateFlow : MutableStateFlow<BaseEvent?> by lazy { MutableStateFlow(null) }
    val eventFlow:StateFlow<BaseEvent?>
        get() = eventStateFlow.asStateFlow()

    @Inject
    lateinit var adsManager: AdsManager

    @Inject
    lateinit var appManager: AppManager

    private val internalState: MutableStateFlow<T> by lazy { MutableStateFlow(initState) }

    val state: StateFlow<T>
        get() = internalState.asStateFlow()

    fun showMessage(msg:String){
        addToEvent(MessageEvent(msg))
    }

    fun showToast(msg:String){
        addToEvent(ToastEvent(msg))
    }

    fun dismissDialog(){
        addToEvent(null)
    }

    fun showLoading(){
        addToEvent(LoadingEvent(isLoading = true))
    }

    fun hideLoading(){
        addToEvent(LoadingEvent(isLoading = false))
    }

    private fun addToEvent(event:BaseEvent?){
        viewModelScope.launch(Dispatchers.Main) {
            eventStateFlow.emit(event)
        }
    }

    fun emit(value:T){
        viewModelScope.launch(Dispatchers.Main) {
            internalState.emit(value)
        }
    }

    fun tryEmit(value:T){
        internalState.tryEmit(value)
    }
}