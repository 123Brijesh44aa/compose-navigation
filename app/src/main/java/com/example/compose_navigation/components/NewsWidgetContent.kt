package com.example.compose_navigation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.example.compose_navigation.API_KEY
import com.example.compose_navigation.viewmodel.NewsViewModel


@Composable
fun NewsWidgetContent(
    modifier:GlanceModifier,
    viewModel: NewsViewModel
){

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchNewsList(query = "tesla", apiKey = API_KEY)
    }

    val news by viewModel.news
    val articles = news.articles

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White) // Set background color
            .padding(12.dp),
        verticalAlignment = Alignment.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "News from API",
            modifier = GlanceModifier.padding(12.dp),
            style = TextStyle(
                fontSize = 19.sp
            )
        )
        Row(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            articles.forEach { article ->
                Text(
                    text = article.title ?: "No Title",
                    modifier = GlanceModifier.padding(8.dp),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                        color = ColorProvider(Color.DarkGray)
                    )
                )
            }

        }
    }
}