package com.ntq.basejetpackcompose.ui.component.home

import com.ntq.basejetpackcompose.ui.base.BaseViewModel
import com.ntq.basejetpackcompose.ui.root.RootNode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState>(HomeState()) {
    fun init(){

    }

    fun openMenu(){
        appManager.pushNode(RootNode.NavTarget.Menu)
    }
}