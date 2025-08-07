package com.example.instagram_clone.uicode

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CustomLoginFields() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var usernameFocused by remember { mutableStateOf(false) }
    var passwordFocused by remember { mutableStateOf(false) }

    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Color.Gray,
        unfocusedIndicatorColor = Color.LightGray,
        cursorColor = Color.Black,
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        // Username Field
        Box {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { usernameFocused = it.isFocused },
                singleLine = true,
                shape = RoundedCornerShape(50),
                colors = colors,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                placeholder = {}
            )

            Text(
                text = "Username, email address or mobile number",
                color = Color.Gray,
                fontSize = if (usernameFocused || username.isNotEmpty()) 12.sp else 16.sp,
                modifier = Modifier.padding(
                    start = 24.dp,
                    top = if (usernameFocused || username.isNotEmpty()) 4.dp else 18.dp
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        Box {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { passwordFocused = it.isFocused },
                singleLine = true,
                shape = RoundedCornerShape(50),
                colors = colors,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                placeholder = {}
            )

            Text(
                text = "Password",
                color = Color.Gray,
                fontSize = if (passwordFocused || password.isNotEmpty()) 12.sp else 16.sp,
                modifier = Modifier.padding(
                    start = 24.dp,
                    top = if (passwordFocused || password.isNotEmpty()) 4.dp else 18.dp
                )
            )
        }
    }
}
