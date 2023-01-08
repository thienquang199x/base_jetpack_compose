package com.ntq.basejetpackcompose.ui.component.menu

import com.ntq.basejetpackcompose.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : BaseViewModel<MenuState>(MenuState()) {
}