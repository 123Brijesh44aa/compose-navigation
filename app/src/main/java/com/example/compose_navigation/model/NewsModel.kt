package com.example.compose_navigation.model


import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("articles")
    val articles: List<Article> = emptyList(),
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)