package com.ntq.basejetpackcompose.extension

import android.content.Context
import androidx.compose.ui.geometry.Size

fun Context.screenSize():Size{
    val displayMetrics = this.resources.displayMetrics
    val height = displayMetrics.heightPixels /displayMetrics.density
    val width = displayMetrics.widthPixels / displayMetrics.density
    return Size(width, height)
}