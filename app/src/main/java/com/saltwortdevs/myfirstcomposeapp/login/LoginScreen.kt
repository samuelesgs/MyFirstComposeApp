package com.saltwortdevs.myfirstcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices.PIXEL_2
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name! bb",
        modifier = modifier
    )
}

@Preview(
    widthDp = 50,
    heightDp = 50,
    showBackground = true,
    showSystemUi = true,
    device = PIXEL_2,
)
@Composable
fun ExamplePreview() {
    Example("ala")
}

@Composable
fun Example(a : String) {
    Text("Samuel $a", Modifier.padding(8.dp).background(Color.Red))

}