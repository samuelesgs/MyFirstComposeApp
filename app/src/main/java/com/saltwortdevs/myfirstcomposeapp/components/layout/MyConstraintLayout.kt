package com.saltwortdevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun MyConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxCyan, boxBlue, boxBlack) = createRefs()
        Box(Modifier.size(150.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxBlack.bottom)
            end.linkTo(boxBlack.start)
        })
        Box(Modifier.size(150.dp).background(Color.Gray).constrainAs(boxGray){
            top.linkTo(boxBlack.bottom)
            start.linkTo(boxBlack.end)
        })
        Box(Modifier.size(150.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxBlack.top)
            start.linkTo(boxBlack.end)
        })
        Box(Modifier.size(150.dp).background(Color.Blue).constrainAs(boxBlue){
            bottom.linkTo(boxBlack.top)
            end.linkTo(boxBlue.start)
        })
        Box(Modifier.size(150.dp).background(Color.Black).constrainAs(boxBlack){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })
    }
}