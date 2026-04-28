package com.saltwortdevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyRow(modifier: Modifier) {
    Row(modifier = modifier.fillMaxSize().horizontalScroll(rememberScrollState())){
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 1")
        Text("hola 5")
    }
}
