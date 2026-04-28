package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.saltwortdevs.myfirstcomposeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {
        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text("idioma") },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded)}
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("Op 1") }, onClick = {
                expanded = false
                selection = "Op 1"
            })
            DropdownMenuItem(text = { Text("Op 2") }, onClick = {
                expanded = false
                selection = "Op 2"
            })
            DropdownMenuItem(text = { Text("Op 3") }, onClick = {
                expanded = false
                selection = "Op 3"
            })
            DropdownMenuItem(text = { Text("Op 4") }, onClick = {
                expanded = false
                selection = "Op 4"
            })
        }
    }
}

@Composable
fun MyDropdownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier.padding(16.dp)) {
        Button(onClick = { expanded = !expanded }) {
            Text("Ver Opciones")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(5.dp, 1.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = false,
                dismissOnBackPress = false,
                clippingEnabled = false
            )
        ) {
            DropdownMenuItem(text = { Text("Op 1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Op 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Op 3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Op 4") }, onClick = { expanded = false })
        }
    }
}

@Composable
fun MyDropdownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = {
                Text("ejemplo 1")
            }, onClick = {},
            enabled = true,
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.person),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.person),
                    contentDescription = ""
                )
            },
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Blue,
                trailingIconColor = Color.Green
            )
        )
    }
}