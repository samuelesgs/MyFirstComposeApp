package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saltwortdevs.myfirstcomposeapp.R


@Preview
@Composable
fun MyButtons(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = {},
            shape = RoundedCornerShape(30),
            border = BorderStroke(10.dp, Red),
            colors = ButtonDefaults.buttonColors(contentColor = Red, containerColor = White)
        ) {
            Column {
                Text("Pulsame")

            }
        }
        OutlinedButton(onClick = {}) {
            Text("Outlined")
        }

        TextButton(onClick = {}) {
            Box {
                Text("TextButton")
            }
        }
        ElevatedButton(onClick = {}) {
            Text("ElevatedButton")
        }

        FilledTonalButton(onClick = {}) {
            Text("FillTonal")
        }
    }
}

@Preview
@Composable
fun MyFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = {}, shape = CircleShape, containerColor = Color.Red, contentColor = Color.Gray, elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 32.dp)) {
        Icon(painter = painterResource(R.drawable.person), contentDescription = null)
    }
}