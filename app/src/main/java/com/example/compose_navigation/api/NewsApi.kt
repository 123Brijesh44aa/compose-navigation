package com.example.compose_navigation.api

import com.example.compose_navigation.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/everything/")
    suspend fun getNewsList(
        @Query("q") query: String? = "tesla",
        @Query("apiKey") apiKey: String? = null
    ) : NewsModel
}