package com.saltwortdevs.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        MyTextField(user) { user = it }
        MySecondTextField(value) { value = it }
        MyAdvanceTextField(value) { value = it }
        MyPasswordTextField(value) {value = it}
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(
        user,
        label = {Text("Introduce tu correo")},
        onValueChange = {
            onUserChange(it)
        }
    )
    Text(user)
}

@Composable
fun MySecondTextField(value: String, onUserChange: (String) -> Unit) {
    TextField(
        value,
        placeholder ={
            Text("Contraseña")
        },
        onValueChange = {
            onUserChange(it)
        }

    )
}

@Composable
fun MyAdvanceTextField(value: String, onUserChange: (String) -> Unit){
    TextField(
        value,
        onValueChange = {
            if (it.contains("a")){
                onUserChange(it.replace("a", ""))
            } else {
                onUserChange(it)
            }
        }
    )
}

@Composable
fun MyPasswordTextField (value: String, onUserChange: (String) -> Unit){
    var passwordHidden by remember { mutableStateOf(false) }

    TextField(
        value,
        onValueChange = {
            onUserChange(it)
        },
        singleLine = true,
        label = {Text("Introduce tu contraseña")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            //Image()
            Text(text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.padding(0.dp,0.dp, 4.dp).clickable{ passwordHidden = !passwordHidden})
        }
    )
    //BasicTextField()
}