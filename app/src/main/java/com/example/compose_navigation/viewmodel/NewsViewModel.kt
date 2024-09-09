package com.example.compose_navigation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_navigation.api.NewsApi
import com.example.compose_navigation.api.RetrofitHelper
import com.example.compose_navigation.model.Article
import com.example.compose_navigation.model.NewsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val _news: MutableState<NewsModel> = mutableStateOf(NewsModel())
    val news: State<NewsModel> = _news

    private val _article: MutableStateFlow<Article> = MutableStateFlow(Article())
    val article: StateFlow<Article> = _article

    private val _error: MutableState<String> = mutableStateOf("")
    val error: State<String> = _error

    private val newsApi: NewsApi = RetrofitHelper.getInstance().create(NewsApi::class.java)


    fun fetchNewsList(query: String?, apiKey: String?) {
        viewModelScope.launch {
            try {
                val newsList = newsApi.getNewsList(query = query, apiKey = apiKey)
                _news.value = newsList
            } catch (e: Exception) {
                e.localizedMessage?.let {
                    _error.value = it
                }
            }
        }
    }

    fun selectArticle(article: Article) {
        viewModelScope.launch {
            _article.update { currentState ->
                currentState.copy(
                    author = article.author,
                    content = article.content,
                    description = article.description,
                    publishedAt = article.publishedAt,
                    source = article.source,
                    title = article.title,
                    url = article.url,
                    urlToImage = article.urlToImage
                )
            }
        }
    }

}