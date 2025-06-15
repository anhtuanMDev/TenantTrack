package com.example.tenanttrack.presentation.main_screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.tenanttrack.presentation.contract_screen.ContractScreen
import com.example.tenanttrack.presentation.navigation.Screen
import com.example.tenanttrack.presentation.property_screen.PropertyScreen
import com.example.tenanttrack.presentation.setting_screen.SettingScreen
import com.example.tenanttrack.presentation.tenant_screen.TenantScreen

fun NavGraphBuilder.bottomTabNavGraph(navController: NavHostController) {
        composable(Screen.Property.route) { PropertyScreen(navController) }
        composable(Screen.Tenant.route) { TenantScreen(navController) }
        composable(Screen.Contract.route) { ContractScreen(navController) }
        composable(Screen.Setting.route) { SettingScreen(navController) }
}