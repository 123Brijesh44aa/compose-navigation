package com.example.compose_navigation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestinations(val route: String){

    @Serializable
    data class Home(val name: String? = null) : AppDestinations("home"){
        fun withArgs(): String {
            return if (name != null){
                "$route/$name"
            } else {
                route
            }
        }
    }

    @Serializable
    data object Profile: AppDestinations("profile")
}