package com.example.compose_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compose_navigation.screens.CollectionScreen
import com.example.compose_navigation.screens.HomeScreen
import com.example.compose_navigation.screens.ProfileScreen
import com.example.compose_navigation.screens.SettingsScreen


@Composable
fun AppNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = AppDestinations.Home.route) {


        composable(
            route = AppDestinations.Home.route
        ) {
            HomeScreen(
                onNavigateToProfile = {
                    navHostController.navigate(route = AppDestinations.Profile.route) {
                        launchSingleTop = true
                    }

                }
            )
        }

        composable(
            route = AppDestinations.Profile.route
        ) {
            ProfileScreen(
                onNavigateToHome = {
                    navHostController.navigate(AppDestinations.Home.route){
                        popUpTo(AppDestinations.Home.route){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = AppDestinations.Settings.route
        ) {
            SettingsScreen()
        }

        composable(
            route = AppDestinations.Collection.route
        ) {
            CollectionScreen()
        }

    }
}