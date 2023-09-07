package com.example.onthedot.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(

) {
    Column {
        InputField("Username")
        PasswordInputField("Password")
        SubmitButton( onClick = {checkInput()} )
    }
}

//check if pwd + username matches the test one (maybe can link up database to this)
fun checkInput() {
    var check = false
    check = true
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label: String,
               modifier: Modifier = Modifier) {
    var input by remember {mutableStateOf("")}
    OutlinedTextField(
        value = input,
        onValueChange = { input = it },
        label = { Text(label)},
        singleLine=true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField(label: String,
               modifier: Modifier = Modifier) {
    var input by remember {mutableStateOf("")}
    OutlinedTextField(
        value = input,
        onValueChange = { input = it },
        visualTransformation=PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text(label)},
        singleLine=true
    )
}

@Composable
fun SubmitButton(onClick: () -> Unit,
                 modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { onClick()}
    ) {
        Text("Submit")
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(

) {
    LoginScreen()
}