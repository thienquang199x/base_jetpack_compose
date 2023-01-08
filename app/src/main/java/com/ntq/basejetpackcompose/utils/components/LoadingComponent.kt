package com.ntq.basejetpackcompose.utils.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.InstaSpinner
import com.ntq.basejetpackcompose.ui.theme.AppDimens

@Composable
fun AppLoadingIndicator(
    color: Color? = null,
    size: Dp = AppDimens.size25.width.dp,
    backgroundColor: Color = Color.White,
    boxSize: Size = AppDimens.size80
) {
    Box(
        modifier = Modifier
            .size(width = boxSize.width.dp, height = boxSize.height.dp)
            .background(backgroundColor, shape = RoundedCornerShape(AppDimens.radius15.dp)),
        contentAlignment = Alignment.Center
    ) {
        InstaSpinner(size = size, color = color ?: Color.Gray)
    }
}


@Composable
fun AppLoadingComponent(message: String? = null, backgroundColor: Color = Color.Black.copy(alpha = 0.5f)) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = backgroundColor), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            AppLoadingIndicator()
            if (message != null){
                Text(text = message, style = MaterialTheme.typography.body1)
            }
        }
    }
}