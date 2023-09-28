package com.example.onthedot.ui.theme.screens

import android.view.RoundedCorner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.onthedot.R
import com.example.onthedot.ui.theme.theme.Brown
import com.example.onthedot.ui.theme.theme.Green
import com.example.onthedot.ui.theme.theme.Grey

@Composable
fun LoginScreen() {


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
                            .fillMaxSize()
            .background(color = Green)
    )
     {
         Text("On the Dot EXAMPLE",
             style = MaterialTheme.typography.displayLarge)
         Spacer(modifier = Modifier.height(height = 400.dp))
        InputField("Username")
         Spacer(modifier = Modifier.height(height = 20.dp))
        PasswordInputField("Password")
        Spacer(modifier = Modifier.height(height = 20.dp))
        SubmitButton(
            onClick = {checkInput()} )
         Spacer(modifier = Modifier.height(height = 20.dp))
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
               modifier: Modifier = Modifier
                   .clip(shape = RoundedCornerShape(50))) {
    var input by remember {mutableStateOf("")}
    TextField(
        value = input,
        onValueChange = { input = it },
        label = { Text(label)},
        singleLine=true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Grey,
            textColor = Color.Black
        ),
        modifier = Modifier
            .graphicsLayer(
                shape = RoundedCornerShape(32.dp)
            ),
        shape = RoundedCornerShape(12.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField(label: String,
               modifier: Modifier = Modifier) {
    var input by remember {mutableStateOf("")}
    TextField(
        value = input,
        onValueChange = { input = it },
        visualTransformation=PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text(label)},
        singleLine=true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Grey
        ),
        shape = RoundedCornerShape(12.dp)
    )
}

@Composable
fun SubmitButton(onClick: () -> Unit,
                 modifier: Modifier = Modifier
                     .fillMaxWidth()) {
    Button(
        onClick = { onClick()},
        colors = ButtonDefaults.buttonColors(containerColor = Brown)
    ) {
        Text("Log In",
            style = MaterialTheme.typography.labelSmall)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(

) {
    LoginScreen()
}