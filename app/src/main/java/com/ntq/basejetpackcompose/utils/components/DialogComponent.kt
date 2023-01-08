package com.ntq.basejetpackcompose.utils.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ntq.basejetpackcompose.ui.theme.AppDimens

@Composable
fun AppDialog(title: String? = null, message:String, buttonTitle:String? = null, onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(AppDimens.radius15.dp)
            )
            .padding(AppDimens.spacing15.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (title != null) {
                Text(text = title, style = MaterialTheme.typography.h2)
            }
            VSpacer(spacing = AppDimens.spacing10.dp)
            Text(text = message, style = MaterialTheme.typography.body1, maxLines = 8, textAlign = TextAlign.Center)
            VSpacer(spacing = AppDimens.spacing30.dp)
            AppPrimaryButton(title = buttonTitle ?: "Close") {
                onClick?.invoke()
            }
        }
    }
}