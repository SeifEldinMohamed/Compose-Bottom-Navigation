package com.seif.composebottomnavigation.components.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreenInfo.Home,
        BottomBarScreenInfo.Profile,
        BottomBarScreenInfo.Settings,
    )
    val navBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState() // when the navBackStackEntry value changed we will be notified
    val currentDestination: NavDestination? = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        screens.forEach { screen ->
            AddItem(
                bottomBarScreenInfo = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    bottomBarScreenInfo: BottomBarScreenInfo,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = bottomBarScreenInfo.title)
        },
        icon = {
            Icon(
                imageVector = bottomBarScreenInfo.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == bottomBarScreenInfo.route
        } == true, // if true then our route is selected
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(bottomBarScreenInfo.route) {
                popUpTo(navController.graph.findStartDestination().id) //
                launchSingleTop = true // allow us to avoid the multiple copies of the same destination when we re selecting the same item
            }
        }
    )
}
