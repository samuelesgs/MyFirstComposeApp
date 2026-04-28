package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.saltwortdevs.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier, onNavSelected:()-> Unit) {
    TopAppBar(
        title = {
            Text("My app")
        },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.baseline_menu_24),
                contentDescription = null,
                modifier = Modifier.clickable{
                    onNavSelected()
                }
            )
            Icon(
                painter = painterResource(R.drawable.person),
                contentDescription = null,
                tint = Color.Blue
            )
            Icon(
                painter = painterResource(R.drawable.person),
                contentDescription = null
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
            scrolledContainerColor = Color.Black,
        ),
    )

}