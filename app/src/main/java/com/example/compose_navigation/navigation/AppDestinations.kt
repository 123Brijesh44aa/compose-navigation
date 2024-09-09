package com.example.compose_navigation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestinations(val route: String){

    @Serializable
    data object Home: AppDestinations(route = "home")

    @Serializable
    data object NewsDetail: AppDestinations(route = "news_detail")

}