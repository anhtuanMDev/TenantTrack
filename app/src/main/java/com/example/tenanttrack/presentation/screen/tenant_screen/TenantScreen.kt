package com.example.tenanttrack.presentation.screen.tenant_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.tenanttrack.R
import com.example.tenanttrack.data.local.entities.TenantStatus
import com.example.tenanttrack.presentation.components.FilterChips
import com.example.tenanttrack.presentation.components.PropertyHeaderBar
import com.example.tenanttrack.presentation.components.SearchBar
import com.example.tenanttrack.ui.theme.Gray50

@Composable
fun TenantScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        TenantContentScreen()
    }
}

@Composable
fun TenantContentScreen() {
    var searchText by remember { mutableStateOf("") }
    val status = listOf("All Tenants") + TenantStatus.entries.map { it.name }
    var category by remember { mutableStateOf("All Tenants") }

    Column(modifier = Modifier.background(Gray50)) {
        PropertyHeaderBar(title = stringResource(id = R.string.tab2_title))
        SearchBar(
            text = searchText, onTextChange = { searchText = it },
            placeholder = stringResource(id = R.string.tab2_search_placeholder)
        )
        FilterChips(
            categories = status,
            selectedCategory = "All Tenants",
            onCategorySelected = { category = it })
    }
}