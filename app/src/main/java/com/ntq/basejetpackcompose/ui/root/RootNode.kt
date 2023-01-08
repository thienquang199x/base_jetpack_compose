package com.ntq.basejetpackcompose.ui.root

import android.os.Parcelable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackFader
import com.ntq.basejetpackcompose.core.manager.app_manager.AppManager
import com.ntq.basejetpackcompose.ui.component.home.HomeNode
import com.ntq.basejetpackcompose.ui.component.menu.MenuNode
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

interface RootNode{
    sealed class NavTarget : Parcelable {
        @Parcelize
        object Home : NavTarget()

        @Parcelize
        object Menu : NavTarget()
    }

    fun initialize()
}

class RootNodeImpl @Inject constructor(
    buildContext: BuildContext,
    private val backStack: BackStack<RootNode.NavTarget> = BackStack(
        initialElement = RootNode.NavTarget.Home,
        savedStateMap = buildContext.savedStateMap
    ),
    private val appManager: AppManager
) : ParentNode<RootNode.NavTarget>(
    buildContext = buildContext,
    navModel = backStack
), RootNode {

    init {
        initialize()
    }

    override fun resolve(navTarget: RootNode.NavTarget, buildContext: BuildContext): Node =
        when (navTarget) {
            is RootNode.NavTarget.Home -> HomeNode(buildContext)
            is RootNode.NavTarget.Menu -> MenuNode(buildContext)
        }

    @Composable
    override fun View(modifier: Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Children(
                navModel = backStack,
                transitionHandler = rememberBackstackFader { spring(stiffness = Spring.StiffnessVeryLow) },
                modifier = Modifier.fillMaxSize()
            )
        }
    }

    override fun initialize() {
        appManager.setUp(backStack)
    }
}