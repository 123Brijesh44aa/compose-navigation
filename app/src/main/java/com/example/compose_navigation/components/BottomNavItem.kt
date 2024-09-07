package com.example.compose_navigation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_navigation.BottomNav

@Composable
fun BottomNavItem(
    bottomNav: BottomNav,
    isSelected: Boolean,
    onNavigate: () -> Unit
) {
//        Icon(imageVector = bottomNav.icon, contentDescription = bottomNav.label)
//        Spacer(modifier = Modifier.height(5.dp))
        TextButton(
            onClick = {
                onNavigate()
            }
        ){
            Text(
                text = bottomNav.label,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = if (isSelected) Color.Green else Color.LightGray
                )
            )
        }

}