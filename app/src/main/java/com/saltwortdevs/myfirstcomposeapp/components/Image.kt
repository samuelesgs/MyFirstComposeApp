package com.saltwortdevs.myfirstcomposeapp.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.saltwortdevs.myfirstcomposeapp.R

@Composable
fun MyImage(modifier: Modifier) {
    Image(
        painter =
            painterResource(R.drawable.images),
        contentDescription = "avatar image profile",
        modifier = Modifier
            .size(300.dp)
            .clip(CircleShape)
            //.border(width=5.dp, color = Color.Red, shape = CircleShape)
            .border(
                width = 5.dp,
                shape = CircleShape,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Blue,
                        Color.Yellow,
                        Color.Green
                    )
                )
            ),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun MyNetWorkImage(modifier: Modifier) {
    AsyncImage(
        model = "https://saltwortdevs.com/assets/images/icon-app.png",
        contentDescription = null,
        modifier = modifier.size(250.dp),
        onError = {
            Log.i("image", "Error: ${it.result.throwable.message}")
        }
    )
}

@Preview
@Composable
fun MyIcon(){
    Icon(
        painter = painterResource(R.drawable.person),
        contentDescription = "icon image",
        modifier = Modifier.size(300.dp),
        tint = Color.Yellow
    )
}