package com.example.compose_navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose_navigation.bottomNavItems
import com.example.compose_navigation.navigation.AppDestinations

@Composable
fun BottomNavigation(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(MaterialTheme.colorScheme.inverseOnSurface),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        bottomNavItems.forEachIndexed { index, bottomNav ->
            val isSelected =
                currentDestination?.hierarchy?.any { it.route == bottomNav.route } == true
            BottomNavItem(
                bottomNav = bottomNav,
                isSelected = isSelected,
                onNavigate = {
                    bottomNav.route?.let {
                        navController.navigate(it){
                            popUpTo(it){
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                }
            )
            if (index != bottomNavItems.size - 1) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = if (isSelected) Color.DarkGray else Color.LightGray
                )
            }
        }
    }
}