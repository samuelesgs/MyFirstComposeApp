package com.saltwortdevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
//@Preview()
fun MyConstraintLayout2(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxYellow, boxPink, boxGray, boxGreen, boxRed, boxBlack, boxBlue, boxCyan, boxBlackGray) = createRefs()

        Box(
            Modifier
                .size(150.dp)
                .padding(16.dp, 0.dp, 16.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Magenta)
                .constrainAs(boxPink) {
                    bottom.linkTo(boxYellow.top)
                    end.linkTo(boxYellow.start)
                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(boxYellow.start)
                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxYellow.top)
                    start.linkTo(boxYellow.end)
                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.end)
                })

        Box(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    bottom.linkTo(boxPink.top)
                    end.linkTo(boxPink.end)

                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    top.linkTo(boxCyan.top)
                    bottom.linkTo(boxCyan.bottom)
                    start.linkTo(boxCyan.end)
                })
        Box(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
                .constrainAs(boxBlackGray) {
                    bottom.linkTo(boxGreen.top)
                    //end.linkTo(parent.end)
                    start.linkTo(boxBlack.end)
                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })
    }
}

@Composable
fun ConstraintExampleLayoutGuide(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        Box(
            Modifier
                .size(150.dp)
                .background(Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                }
        )
    }
}

@Composable
fun ConstraintBarrier(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()
        val barrier = createEndBarrier(boxRed, boxYellow)

        Box(
            Modifier
                .size(65.dp)
                .background(Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })
        Box(
            Modifier
                .size(250.dp)
                .background(Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(boxRed.bottom, margin = 40.dp)
                    start.linkTo(parent.start, 32.dp)
                })
        Box(
            Modifier
                .size(70.dp)
                .background(Cyan)
                .constrainAs(boxCyan) {
                    start.linkTo(barrier)
                })
    }
}

@Composable
fun ConstraintChain(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()
        val barrier = createEndBarrier(boxRed, boxYellow)

        Box(
            Modifier
                .size(100.dp)
                .background(Red)
                .constrainAs(boxRed) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(boxYellow.top)
                }
        )
        Box(
            Modifier
                .size(100.dp)
                .background(Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(boxRed.bottom)
                    bottom.linkTo(boxCyan.top)
                }
        )
        Box(
            Modifier
                .size(100.dp)
                .background(Cyan)
                .constrainAs(boxCyan) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(boxYellow.bottom)
                    bottom.linkTo(parent.bottom)
                }
        )
        //createVerticalChain(boxRed,boxYellow,boxCyan, chainStyle = ChainStyle.Packed)
        //createVerticalChain(boxRed,boxYellow,boxCyan, chainStyle = ChainStyle.Spread)
        createVerticalChain(boxRed,boxYellow,boxCyan, chainStyle = ChainStyle.SpreadInside)
    }
}







