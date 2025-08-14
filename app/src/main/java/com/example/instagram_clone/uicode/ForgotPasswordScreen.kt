package com.example.instagram_clone.uicode

import android.R.attr.enabled
import android.R.attr.text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItemDefaults.colors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_clone.ui.theme.PrimaryBlue

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.example.instagram_clone.R
import com.example.instagram_clone.ui.theme.Black


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ForgotPasswordScreen(modifier: Modifier = Modifier) {

    var enabled by remember { mutableStateOf(true) }
    var forgotPasswordText by remember { mutableStateOf("") }
    var forgotPasswordFocused by remember { mutableStateOf(false) }

    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Color(0xFF808080),
        unfocusedIndicatorColor = Color(0xFFD3D3D3),
        cursorColor = Color(0xFF000000),
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(20.dp))

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "What's your email address or",
            fontSize = 28.sp,
            fontWeight = FontWeight.W600
        )
        Text(
            text = "username?",
            fontSize = 28.sp,
            fontWeight = FontWeight.W600
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "We'll help you find your account",
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.height(4.dp))

        BlueClickableText()
        Spacer(modifier = Modifier.height(16.dp))

        // Instagram-style floating label input
        Box {
            OutlinedTextField(
                value = forgotPasswordText,
                onValueChange = { forgotPasswordText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { forgotPasswordFocused = it.isFocused },
                singleLine = true,
                shape = RoundedCornerShape(27),
                colors = colors,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                placeholder = {},
            )

            Text(
                text = "Email address or username",
                color = Color.Gray,
                fontSize = if (forgotPasswordFocused || forgotPasswordText.isNotEmpty()) 12.sp else 16.sp,
                modifier = Modifier.padding(
                    start = 24.dp,
                    top = if (forgotPasswordFocused || forgotPasswordText.isNotEmpty()) 4.dp else 18.dp
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "You may receive WhatsApp and SMS notifications from us", color = Color.Gray)
        Text(text = "for security and login purposes.", color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))
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
            Text(text = "Continue", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Search by mobile number instead",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp),
                color = Color.LightGray
            )

            Text(
                text = "OR",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Color.Gray
            )

            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp),
                color = Color.LightGray
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = {

            }, colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Black
            ),
            shape = RoundedCornerShape(27.dp), modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Row {
                Icon(
                    painterResource(R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier.size(
                        18.dp
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Log in with Facebook")
            }
        }
    }
}

@Composable
fun BlueClickableText() {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("Can't reset your password?")
        }
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
        }
    )
}
