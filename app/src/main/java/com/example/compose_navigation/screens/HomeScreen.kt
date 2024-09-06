package com.example.compose_navigation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    home: String?,
    onNavigateToProfile: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 50.dp),
            text = home ?: "No Data",
            style = TextStyle(
                fontSize = 40.sp
            )
        )
        OutlinedButton(
            modifier = Modifier
                .padding(20.dp)
                .size(height = 60.dp, width = 300.dp),
            onClick = {
                onNavigateToProfile()
            },
            shape = RoundedCornerShape(16),
            border = BorderStroke(width = 3.dp, color = Color.Green)
        ) {
            Text(text = "Go To Profile", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold), color = Color.White)
        }
    }
}