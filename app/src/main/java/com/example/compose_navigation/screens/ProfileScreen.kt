package com.example.compose_navigation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    onNavigateToHome: (data: String) -> Unit
) {

    val data = remember {
        mutableStateOf<String>("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier
                .size(height = 90.dp, width = 400.dp),
            value = data.value,
            onValueChange = { newValue ->
                data.value = newValue
            },
            label = {
                Text(text = "Name", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green))
            },
            placeholder = {
                Text(text = "Type your name...", style = TextStyle(color = Color.White))
            },
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                cursorColor = Color.Green,
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Green
            ),
            textStyle = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            ),
        )

        Box(modifier = Modifier.height(50.dp))

        OutlinedButton(
            modifier = Modifier
                .padding(20.dp)
                .size(height = 60.dp, width = 300.dp),
            onClick = {
                onNavigateToHome(data.value)
            },
            shape = RoundedCornerShape(16),
            border = BorderStroke(width = 3.dp, color = Color.Green)
        ) {
            Text(text = "Go To Home", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold), color = Color.White)
        }

    }
}