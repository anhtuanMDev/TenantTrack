package com.example.tenanttrack.presentation.screen.main_screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.tenanttrack.presentation.screen.contract_screen.ContractScreen
import com.example.tenanttrack.presentation.screen.navigation.Screen
import com.example.tenanttrack.presentation.screen.property_screen.PropertyScreen
import com.example.tenanttrack.presentation.screen.setting_screen.SettingScreen
import com.example.tenanttrack.presentation.screen.tenant_screen.TenantScreen

fun NavGraphBuilder.bottomTabNavGraph(navController: NavHostController) {
        composable(Screen.Property.route) { PropertyScreen(navController) }
        composable(Screen.Tenant.route) { TenantScreen(navController) }
        composable(Screen.Contract.route) { ContractScreen(navController) }
        composable(Screen.Setting.route) { SettingScreen(navController) }
}