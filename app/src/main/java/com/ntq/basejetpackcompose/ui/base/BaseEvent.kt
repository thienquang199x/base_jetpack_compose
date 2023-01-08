package com.ntq.basejetpackcompose.ui.base

abstract class BaseEvent

data class MessageEvent(val msg:String): BaseEvent()

data class ToastEvent(val msg:String, private val time:Long = System.currentTimeMillis()): BaseEvent()

data class LoadingEvent(val isLoading:Boolean): BaseEvent()
