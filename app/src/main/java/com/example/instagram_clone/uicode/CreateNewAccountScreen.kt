package com.example.instagram_clone.uicode

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateNewAccountScreen() {
    var mobilenumbertext by remember { mutableStateOf("") }
    var mobilenumberfocused by remember { mutableStateOf(false) }
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Color(0xFF808080),
        unfocusedIndicatorColor = Color(0xFFD3D3D3),
        cursorColor = Color(0xFF000000),
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = "What's your mobile number?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 2.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Enter the mobile number on which you can be",
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        )
        Text(
            text = "contacted.No one will see this on your profile.",
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = mobilenumbertext,
                onValueChange = { new ->
                    mobilenumbertext = new
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        mobilenumberfocused = focusState.isFocused
                    },
                singleLine = true,
                shape = RoundedCornerShape(27),
                colors = colors,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                placeholder = {}
            )

            Text(
                text = "Mobile number",
                color = Color.Gray,
                fontSize = if (mobilenumberfocused || mobilenumbertext.isNotEmpty()) 12.sp else 16.sp,
                modifier = Modifier.padding(
                    start = 24.dp,
                    top = if (mobilenumberfocused || mobilenumbertext.isNotEmpty()) 4.dp else 18.dp
                )
            )

        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "You may receive Whatsapp and SMS notifications from us",
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "for security and login purposes.",
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

            }, modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF257CBD),
                contentColor = Color.White
            ), shape = RoundedCornerShape(27.dp)
        ) {
            Text(text = "Next", fontSize = 16.sp, fontWeight = FontWeight.Normal)
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ), shape = RoundedCornerShape(27.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Text(
                text = "Sign up with email address",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(200.dp))
        Box(modifier = Modifier.padding(start = 100.dp, top = 230.dp)) {
            BlueClickabletext()
        }
    }
}

@Composable
fun BlueClickabletext() {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("I already have an account")
        }
    }
    ClickableText(
        text = annotatedText,
        onClick = { offset ->

        }
    )
}