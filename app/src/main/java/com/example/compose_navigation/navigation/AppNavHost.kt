package com.example.compose_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compose_navigation.screens.HomeScreen
import com.example.compose_navigation.screens.ProfileScreen


@Composable
fun AppNavHost(navHostController: NavHostController, modifier: Modifier) {
    NavHost(navController = navHostController, startDestination = AppDestinations.Home().route+"/{name}") {


        composable(
            route = "${AppDestinations.Home().route}/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { navBackStackEntry ->
            val home = navBackStackEntry.arguments?.getString("name")
            HomeScreen(
                home = home,
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
                onNavigateToHome = { data ->
                    navHostController.navigate(AppDestinations.Home(name = data).withArgs()){
                        popUpTo(AppDestinations.Home().route){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

    }
}