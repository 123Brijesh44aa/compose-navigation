package com.example.compose_navigation.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.compose_navigation.viewmodel.NewsViewModel

@Composable
fun DetailScreen(
    modifier: Modifier,
    viewModel: NewsViewModel
) {

    val article by viewModel.article.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .animateContentSize() // Smooth content resizing
            .fillMaxHeight()
            .fillMaxWidth()
            .scale(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        // Image with rounded corners
        AsyncImage(
            modifier = Modifier
                .height(400.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            model = article.urlToImage ?: "https://clarionhealthcare.com/wp-content/uploads/2020/12/default-fallback-image.png",
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFE8F5E9))
                .padding(12.dp)
                .verticalScroll(rememberScrollState())
        )
        {
            // Text elements
            article.title?.let {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    text = it,
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.DarkGray
                    ),
                )
            }

            article.publishedAt?.let {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 10.dp), // Background ,
                    text = it,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    ),
                )
            }

            article.author?.let {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 8.dp),
                    text = it,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.DarkGray,
                        fontStyle = FontStyle.Italic
                    ),
                )
            }
            article.description?.let {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp), // Background ,
                    text = it,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.DarkGray
                    ),
                )
            }
            article.url?.let {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 20.dp), // Background ,
                    text = it,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF195AC9)
                    ),
                )
            }

            article.content?.let {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp), // Background ,
                    text = it,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.DarkGray
                    ),
                )
            }

        }

    }
}


@Composable
@Preview
fun DetailScreenPreview(){
    DetailScreen(modifier = Modifier, viewModel = NewsViewModel())
}
