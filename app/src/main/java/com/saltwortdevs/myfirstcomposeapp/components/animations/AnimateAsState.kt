package com.saltwortdevs.myfirstcomposeapp.components.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FullAnimateAsState(modifier: Modifier = Modifier) {

    var isSelected by remember { mutableStateOf(false) }
    val animatedColor by animateColorAsState(targetValue = if (isSelected) Color.Red else Color.Blue)
    val animatedSize by animateDpAsState( if (isSelected)300.dp else 150.dp)
    val animatedOffSet by animateOffsetAsState(if (isSelected) Offset(0f,100f) else Offset(0f,0f))
    val animatedFloat by animateFloatAsState(targetValue = if (isSelected) 0f else 1f)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(Modifier.height(32.dp))

        Button({ isSelected = !isSelected }) {
            Text("Seleccionar")
        }
        Text("Float: %.2f".format(animatedFloat))
        Spacer(Modifier.height(32.dp))

        Box(Modifier
            .offset(animatedOffSet.x.dp, animatedOffSet.y.dp)
            .size(animatedSize)
            .background(animatedColor.copy(animatedFloat))) {

        }
    }
}