package com.ntq.basejetpackcompose.utils.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ntq.basejetpackcompose.ui.theme.AppDimens

@Composable
fun AppPrimaryButton(
    title: String,
    buttonColor: Color? = null,
    titleStyle: TextStyle? = null,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .defaultMinSize(minHeight = 1.dp, minWidth = 1.dp)
            .background(buttonColor ?: MaterialTheme.colors.primary, shape = RoundedCornerShape(AppDimens.radius12.dp)),
        onClick = onClick,
        enabled = enable,
        contentPadding = PaddingValues(horizontal = AppDimens.spacing20.dp, vertical = AppDimens.spacing10.dp),
        shape = RoundedCornerShape(AppDimens.radius12.dp)
    ) {
        Text(text = title, style = titleStyle ?: MaterialTheme.typography.button)
    }
}