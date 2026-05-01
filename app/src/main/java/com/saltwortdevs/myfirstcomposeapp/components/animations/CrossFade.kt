package com.saltwortdevs.myfirstcomposeapp.components.animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.saltwortdevs.myfirstcomposeapp.components.navigation.DetailScreen
import com.saltwortdevs.myfirstcomposeapp.components.navigation.HomeScreen
import com.saltwortdevs.myfirstcomposeapp.components.navigation.LoginScreen

@Composable
fun MyCrossFade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }
    Column {
        Row(Modifier.padding(top = 62.dp).fillMaxWidth().background(Color.White)) {
            Text("Home", Modifier.clickable{ currentScreen = "Home"})
            Text("Detail", Modifier.clickable{ currentScreen = "Detail"})
            Text("Login", Modifier.clickable{ currentScreen = "Login"})
        }
    }
    Crossfade(targetState = currentScreen) { screen ->
        when(screen) {
            "Home" -> HomeScreen({}, {})
            "Detail" -> DetailScreen ("", {})
            "Login" -> LoginScreen{ }
        }
    }
}