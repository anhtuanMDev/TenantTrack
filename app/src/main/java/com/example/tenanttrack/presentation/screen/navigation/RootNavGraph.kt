package com.example.tenanttrack.presentation.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tenanttrack.presentation.screen.add_property.AddPropertyScreen
import com.example.tenanttrack.presentation.screen.main_screen.MainScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.MAIN
    ) {
        composable(Graph.MAIN) {
            val bottomNavController = rememberNavController()
            MainScreen(bottomNav = bottomNavController, rootNavController = navController)
        }
        composable(Graph.ADD_PROPERTY) {
            AddPropertyScreen(navController)
        }
    }
}
