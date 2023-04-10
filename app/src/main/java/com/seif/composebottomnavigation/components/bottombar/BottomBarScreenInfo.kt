package com.seif.composebottomnavigation.components.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreenInfo(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreenInfo(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarScreenInfo(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Settings : BottomBarScreenInfo(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}