package com.seif.composebottomnavigation.components.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.seif.composebottomnavigation.screens.HomeScreen
import com.seif.composebottomnavigation.screens.ProfileScreen
import com.seif.composebottomnavigation.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreenInfo.Home.route
    ) {
        composable(route = BottomBarScreenInfo.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreenInfo.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreenInfo.Settings.route) {
            SettingsScreen()
        }
    }
}