package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.saltwortdevs.myfirstcomposeapp.R

@Composable
fun MyBadGet(modifier: Modifier = Modifier) {
    Badge(contentColor = Color.Gray, containerColor = Color.DarkGray) {
        Text("5")
    }
}

@Composable
@Preview
fun MyBadGetBox(modifier: Modifier = Modifier) {
    BadgedBox(badge = { MyBadGet() }) {
        Icon(painter = painterResource(R.drawable.person), contentDescription = "")
    }
}