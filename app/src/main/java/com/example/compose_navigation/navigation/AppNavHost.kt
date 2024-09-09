package com.example.compose_navigation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.EaseInOutBack
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose_navigation.screens.DetailScreen
import com.example.compose_navigation.screens.HomeScreen
import com.example.compose_navigation.viewmodel.NewsViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: NewsViewModel,
) {
    NavHost(
        navController = navHostController,
        startDestination = AppDestinations.Home.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(route = AppDestinations.Home.route) {
            HomeScreen(
                modifier = modifier,
                viewModel = viewModel,
                onNavigateToNewsDetailWithArticle = { article ->
                    viewModel.selectArticle(article)
                    navHostController.navigate(AppDestinations.NewsDetail.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = AppDestinations.NewsDetail.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        700, easing = CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f)
                    )
                ) + scaleIn(
                    initialScale = 0.8f,
                    animationSpec = tween(700, easing = EaseOutElastic)
                ) + slideIntoContainer(
                    animationSpec = tween(700, easing = EaseInOutBack),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        500, easing = CubicBezierEasing(0.32f, 0f, 0.67f, 0f)
                    )
                ) + scaleOut(
                    targetScale = 0.9f,
                    animationSpec = tween(500, easing = EaseInBack)
                ) + slideOutOfContainer(
                    animationSpec = tween(500, easing = EaseInOutBack),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            DetailScreen(
                modifier = modifier,
                viewModel = viewModel
            )
        }

    }
}
