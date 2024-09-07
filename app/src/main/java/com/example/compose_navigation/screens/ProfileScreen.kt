package com.example.compose_navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    onNavigateToHome: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.padding(bottom = 50.dp),
            text = "Profile Screen",
            style = TextStyle(
                fontSize = 40.sp
            )
        )

//        OutlinedButton(
//            modifier = Modifier
//                .padding(20.dp)
//                .size(height = 60.dp, width = 300.dp),
//            onClick = {
//                onNavigateToHome()
//            },
//            shape = RoundedCornerShape(16),
//            border = BorderStroke(width = 3.dp, color = Color.Green)
//        ) {
//            Text(text = "Go To Home", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold), color = Color.White)
//        }

    }
}