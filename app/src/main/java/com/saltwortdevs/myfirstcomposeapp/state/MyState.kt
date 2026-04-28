package com.saltwortdevs.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier: Modifier) {

    Column(modifier = modifier){
        var number by rememberSaveable { mutableIntStateOf(0) }
        StateExample1(number) { number += 1 }
        StateExample2(number) { number += 1 }
    }
    /*var number = remember { mutableStateOf(0)}
    Column() {
        Text("Pulsame : ${number.value}", modifier = modifier.clickable { number.value += 1 })
        Text("Pulsame : ${number.value}", modifier = modifier.clickable { number.value += 1 })
    }*/

}

@Composable
fun StateExample1(number : Int, onClick:() -> Unit) {
    Column {
        Text("Pulsame : $number", modifier = Modifier.clickable {
            onClick()
        })
    }
}

@Composable
fun StateExample2(number : Int, onClick:() -> Unit) {
    Column {
        Text("Pulsame : $number", modifier = Modifier.clickable {onClick() })
    }
}