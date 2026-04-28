package com.saltwortdevs.myfirstcomposeapp

import android.icu.util.Calendar
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Entendido")
                }
            },
            dismissButton = { TextButton(onClick = {}) { Text("Cancel") } },
            shape = RoundedCornerShape(8),
            text = { Text("Seguro?") },
            title = {
                Text("Accion requerida")
            },
            icon = { Icon(imageVector = Icons.Default.Info, contentDescription = "") },
            containerColor = Color.DarkGray,
            iconContentColor = Color.White,
            textContentColor = Color.White,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true,

                )
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, +1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024..2026,
        initialDisplayMode = DisplayMode.Picker,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar = Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }
    )
    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    val result = datePickerState.selectedDateMillis
                    if (result!= null) {
                        val newCalendar = Calendar.getInstance().apply { timeInMillis = result }
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month = newCalendar.get(Calendar.MONTH) + 1
                        Log.i("MY_DATE_DIALOG", "MyDateDialog:  day = $day, month = $month")
                    }
                }) {
                    Text("Confirmar")
                }
            },
            colors = DatePickerDefaults.colors(),
            shape = RoundedCornerShape(15)
        ) {
            DatePicker(datePickerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimePicker by remember { mutableStateOf(true) }
    val timePickerState = rememberTimePickerState(
        initialHour = 7,
        initialMinute = 33,
        is24Hour = false
    )
    if (showTimePicker){
        Dialog(onDismissRequest = {showTimePicker = false}) {
            Column(modifier = Modifier.background(Color.White).padding(24.dp)) {
                TimePicker(
                    timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.Gray,
                        clockDialUnselectedContentColor = Color.Black,
                        selectorColor = Color.Blue,
                        clockDialSelectedContentColor = Color.DarkGray,
                        containerColor = Color.Green,
                        periodSelectorBorderColor = Color.DarkGray,
                        periodSelectorSelectedContentColor = Color.Gray,
                        periodSelectorUnselectedContentColor = Color.White,
                        periodSelectorUnselectedContainerColor = Color.Gray,
                        periodSelectorSelectedContainerColor = Color.DarkGray,
                        timeSelectorSelectedContentColor = Color.DarkGray,
                        timeSelectorUnselectedContentColor = Color.DarkGray,
                        timeSelectorSelectedContainerColor = Color.Gray,
                        timeSelectorUnselectedContainerColor = Color.DarkGray,

                    ),
                )
            }
        }
    }
}