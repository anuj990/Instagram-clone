package com.example.instagram_clone.uicode

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_clone.R
import com.example.instagram_clone.ui.theme.LightBlue

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Color.Gray,
        unfocusedIndicatorColor = Color.LightGray,
        cursorColor = Color.Black,
    )

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var usernameFocused by remember { mutableStateOf(false) }
    var passwordFocused by remember { mutableStateOf(false) }
    var passwordvisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        // Language Selector
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "English (UK)", color = Color.Gray)
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        // Logo
        Image(
            painter = painterResource(R.drawable.instagram_splashscreen),
            contentDescription = null,
            modifier = Modifier.size(85.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Username field
        Box {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { usernameFocused = it.isFocused },
                singleLine = true,
                shape = RoundedCornerShape(27),
                colors = colors,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                placeholder = {},
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

        // Password field
        Box {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { passwordFocused = it.isFocused },
                singleLine = true,
                shape = RoundedCornerShape(27),
                colors = colors,
                visualTransformation = if (passwordvisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                placeholder = {},
                trailingIcon = {
                    if (passwordvisible) {
                        IconButton(onClick = { passwordvisible = false }) {
                            Icon(imageVector = Icons.Filled.Visibility, contentDescription = null)
                        }

                    } else {
                        IconButton(onClick = { passwordvisible = true }) {
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    }
                }
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
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /* Handle login */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF257CBD),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(27.dp)
        ) {
            Text(text = "Log In", fontSize = 16.sp)
        }
        Spacer(Modifier.height(10.dp))

        TextButton(onClick = {

        }) {
            Text(text = "Forgotten password?", color = Color.Black, fontSize = 16.sp)
        }
        Spacer(modifier.padding(bottom = 200.dp))
        OutlinedButton(
            onClick = {
            },
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Color(0xFF257CBD)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(27.dp)
        ) {
            Text(text = "Create new account", color = LightBlue, fontSize = 16.sp)
        }
    }
}
