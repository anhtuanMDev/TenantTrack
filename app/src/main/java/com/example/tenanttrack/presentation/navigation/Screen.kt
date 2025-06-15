package com.example.tenanttrack.presentation.navigation
import androidx.compose.ui.res.stringResource
import com.example.tenanttrack.R

sealed class Screen(val route: String, val titleResId: Int, val icon: Int? = null) {
    object Property : Screen("home", R.string.tab1_label, R.drawable.building_2)
    object Tenant : Screen("tenant", R.string.tab2_label, R.drawable.tenants)
    object Contract : Screen("contract", R.string.tab3_label, R.drawable.file_text)
    object Setting : Screen("setting", R.string.tab4_label, R.drawable.settings)

    object Main: Screen("main", R.string.empty_string)
    object DetailProperty: Screen("detail_property", R.string.empty_string)
    object DetailRoom: Screen("detail_room", R.string.empty_string)
    object DetailTenant: Screen("detail_tenant", R.string.empty_string)

    companion object {
        val items = listOf(Property, Tenant, Contract, Setting)

        fun fromRoute(route: String?): Screen = when (route) {
            Property.route -> Property
            Tenant.route -> Tenant
            Contract.route -> Contract
            Setting.route -> Setting
            else -> Property
        }
    }

}