package com.example.instagram_clone.uicode

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_clone.R
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.instagram_splashscreen),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "from",
                color = Color.Gray,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                painter = painterResource(R.drawable.meta_logo),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
