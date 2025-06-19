package com.example.tenanttrack.presentation.screen.main_screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tenanttrack.R
import com.example.tenanttrack.presentation.screen.navigation.Graph
import com.example.tenanttrack.presentation.screen.navigation.Screen
import com.example.tenanttrack.ui.theme.Blue
import com.example.tenanttrack.ui.theme.Gray400
import com.example.tenanttrack.ui.theme.LightBlue
import com.example.tenanttrack.ui.theme.White

@Suppress("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(rootNavController: NavHostController, bottomNav: NavHostController) {
    val navBackStackEntry by bottomNav.currentBackStackEntryAsState()
    val currentRoute = Screen.fromRoute(navBackStackEntry?.destination?.route)

    Scaffold(
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = White,
                tonalElevation = 0.dp,
                modifier = Modifier
                    .height(110.dp)
                    .padding(0.dp)
            ) {
                Screen.items.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute.route == destination.route,
                        onClick = {
                            bottomNav.navigate(destination.route) {
                                popUpTo(bottomNav.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = destination.icon!!),
                                contentDescription = null,
                                tint = if (currentRoute.route == destination.route) Blue else Gray400
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = destination.titleResId),
                                color = if (currentRoute.route == destination.route) Blue else Gray400
                            )
                        },
                        alwaysShowLabel = false,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Blue,
                            unselectedIconColor = Gray400,
                            selectedTextColor = Blue,
                            indicatorColor = LightBlue
                        ),
                        modifier = Modifier.height(60.dp)
                    )
                }
            }
        },
        floatingActionButton = {
            if (currentRoute.route == Screen.Property.route) {
                FloatingActionButton(
                    containerColor = Blue,
                    onClick = { rootNavController.navigate(Graph.ADD_PROPERTY) }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = "Add",
                        tint = White
                    )
                }
            }
        }

    ) { _ ->
        NavHost(
            navController = bottomNav,
            startDestination = Screen.Property.route,
        ) {
            bottomTabNavGraph(bottomNav)
        }
    }
}