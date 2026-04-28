package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.saltwortdevs.myfirstcomposeapp.components.state.CheckBoxState

@Composable
fun MyCheckBox(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        /*Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = state,
                onCheckedChange = {
                    state = it
                },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Red,
                    uncheckedColor = Magenta,
                    checkmarkColor = Yellow,
                    disabledCheckedColor = Green,
                    disabledUncheckedColor = Blue,
                )
            )
            Text("Acepto")
        }
    }*/
    }
}


@Composable()
fun ParentCheckBox(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState("terms", "Aceptar terminos y codiciones"),
                CheckBoxState("newLetter", "Recibir newsletter"),
                CheckBoxState("updates", "Recibir actualizaciones"),
            )
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            MyCheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (myState.id == it.id) {
                        it.copy(checked = !it.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun MyCheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChanged: (checkBoxState: CheckBoxState) -> Unit
) {
    Box(contentAlignment = Alignment.Center) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkBoxState.checked,
                onCheckedChange = {
                    onCheckedChanged(checkBoxState)
                },
                enabled = true,
            )
            Text(checkBoxState.label)
        }
    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child2, child1) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = newState
            })
            Text("Seleccionar todo")
        }
        Column(modifier = Modifier.padding(4.dp)) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(child1, onCheckedChange = { child1 = it })
                Text("Child 1")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(child2, onCheckedChange = { child2 = it })
                Text("Child 2 ")
            }
        }
    }
}


@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            modifier = Modifier,
            selected = state,
            onClick = { state = true },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                Color.Green,
                Color.Blue
            )
        )
        Text("Ejemplo 1")
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {

    var selectedName by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        RadioButtonComponent("samuel", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("samuel1", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("samuel2", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("samuel3", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("samuel4", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("samuel5", selectedName = selectedName) { selectedName = it }
    }
}

@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp).background(Color.Red).fillMaxWidth()) {
        RadioButton(
            modifier = Modifier,
            selected = name == selectedName,
            onClick = { onItemSelected(name) },
        )
        Text(name, modifier = Modifier.clickable {
            onItemSelected(name)
        })
    }

}