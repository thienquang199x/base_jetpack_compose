package com.ntq.basejetpackcompose.utils.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VSpacer(spacing:Dp){
    Spacer(modifier = Modifier.height(spacing))
}

@Composable
fun HSpacer(spacing:Dp){
    Spacer(modifier = Modifier.width(spacing))
}