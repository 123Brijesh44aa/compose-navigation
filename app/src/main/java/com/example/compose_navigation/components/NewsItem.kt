package com.example.compose_navigation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun NewsItem(
    imageUrl: String?,
    title: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp, start = 2.dp, end = 2.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {

        val actualImage = imageUrl ?: "https://clarionhealthcare.com/wp-content/uploads/2020/12/default-fallback-image.png"

        // News image
        AsyncImage(
            model = actualImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
//                .height(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        // News title
        Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = Color.DarkGray
            ),
            modifier = Modifier.padding(horizontal = 8.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

    }

}