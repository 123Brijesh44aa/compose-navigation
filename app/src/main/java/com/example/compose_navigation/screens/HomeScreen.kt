package com.example.compose_navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_navigation.API_KEY
import com.example.compose_navigation.components.NewsItem
import com.example.compose_navigation.model.Article
import com.example.compose_navigation.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: NewsViewModel,
    onNavigateToNewsDetailWithArticle: (article: Article) -> Unit
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchNewsList(query = "tesla", apiKey = API_KEY)
    }

    val newsList by viewModel.news

    val articles = newsList.articles

    LazyVerticalStaggeredGrid(
        modifier = modifier
            .padding(horizontal = 8.dp),
        columns = StaggeredGridCells.Adaptive(200.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(articles) { _, article ->
            NewsItem(
                imageUrl = article.urlToImage,
                title = article.title!!,
                onClick = {
                   onNavigateToNewsDetailWithArticle(article)
                }
            )
        }
    }
}