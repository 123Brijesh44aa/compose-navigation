package com.example.compose_navigation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.compose_navigation.components.BottomNavigation
import com.example.compose_navigation.navigation.AppNavHost

@Composable
fun MainScreen(navController: NavHostController, modifier: Modifier){

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        // 1. Content Area ( Dynamic screens based on navigation )
        Box(modifier = modifier.weight(1f)){
           AppNavHost(navHostController = navController)
        }
        // 2. Custom Bottom Navigation with Row()
        BottomNavigation(navController = navController)
    }
}