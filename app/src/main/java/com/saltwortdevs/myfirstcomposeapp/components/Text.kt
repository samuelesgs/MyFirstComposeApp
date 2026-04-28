package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier) {
        val styleText = TextStyle(fontSize = 10.sp, color = Red, fontStyle = FontStyle.Italic, letterSpacing = 10.sp)
        Text("Halo")
        Text("Halo red", color = Red)
        Text("Halo small", style = styleText)
        Text("Halo fontwei", fontWeight = FontWeight.ExtraBold)
        Text("LetterSpacing", letterSpacing = 10.sp)
        Text("TextDecoration", textDecoration = TextDecoration.LineThrough + TextDecoration.Underline)
        Text("aling", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}