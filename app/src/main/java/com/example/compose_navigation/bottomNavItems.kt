package com.example.compose_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.compose_navigation.navigation.AppDestinations

data class BottomNav(val label: String, val icon: ImageVector, val route: String? = null)

val bottomNavItems = listOf(
    BottomNav(label = "Home", icon = Icons.Filled.Home, route = AppDestinations.Home.route),
    BottomNav(label = "Settings", icon = Icons.Filled.Settings, route = AppDestinations.Settings.route),
    BottomNav(label = "Collection", icon = Icons.Filled.List, route = AppDestinations.Collection.route),
    BottomNav(label = "Profile", icon = Icons.Filled.Person, route = AppDestinations.Profile.route),
)