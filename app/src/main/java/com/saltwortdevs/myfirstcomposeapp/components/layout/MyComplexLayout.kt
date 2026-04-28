package com.saltwortdevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout(modifier: Modifier){
    Column {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Red)){}
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Blue)){
            Row {
                Box(Modifier.weight(1f).height(125.dp).background(Color.Green)){

                }
                Box(Modifier.weight(1f).height(180.dp).background(Color.Gray), contentAlignment = Alignment.Center){
                    Text("hola")
                }
            }
        }
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Yellow)){}
    }
}