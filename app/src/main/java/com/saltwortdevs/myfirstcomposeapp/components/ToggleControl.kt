package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.saltwortdevs.myfirstcomposeapp.R

@Composable
fun MySwitch(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked, onCheckedChange = {
            checked = it
        }, thumbContent = {
            if (checked) {
                Icon(painter = painterResource(R.drawable.person), contentDescription = "")
            } else {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            }
        }, enabled = true,
            colors = SwitchDefaults.colors(
                //Bolita
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Cyan,
                //Icono
                checkedIconColor = Color.White,
                uncheckedIconColor = Color.DarkGray,
                disabledUncheckedIconColor = Color.Red,
                disabledCheckedIconColor = Color.Red,
                //Border
                checkedBorderColor = Color.Magenta,
                uncheckedBorderColor = Color.Magenta,
                disabledUncheckedBorderColor = Color.Magenta,
                disabledCheckedBorderColor = Color.Magenta,
                //Track
                checkedTrackColor = Color.Blue,
                uncheckedTrackColor = Color.DarkGray,
                disabledCheckedTrackColor = Color.White,
                disabledUncheckedTrackColor = Color.Black
            )
        )
    }
}