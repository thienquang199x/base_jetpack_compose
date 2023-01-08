package com.ntq.basejetpackcompose.core.manager.app_manager

import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.operation.pop
import com.bumble.appyx.navmodel.backstack.operation.push
import com.bumble.appyx.navmodel.backstack.operation.replace
import com.ntq.basejetpackcompose.ui.root.RootNode

class AppManager {

    lateinit var backStack: BackStack<RootNode.NavTarget>

    fun setUp(backStack: BackStack<RootNode.NavTarget>){
        this.backStack = backStack
    }

    fun pushNode(target: RootNode.NavTarget){
        backStack.push(target)
    }

    fun popNode(){
        backStack.pop()
    }

    fun replaceNode(target: RootNode.NavTarget){
        backStack.replace(target)
    }
}