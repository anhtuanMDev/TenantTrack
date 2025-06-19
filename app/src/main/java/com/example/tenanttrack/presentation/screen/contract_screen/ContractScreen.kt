package com.example.tenanttrack.presentation.screen.contract_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.tenanttrack.R
import com.example.tenanttrack.presentation.components.PropertyHeaderBar
import com.example.tenanttrack.ui.theme.Gray50

@Composable
fun ContractScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        ContractContentScreen()
    }
}

@Composable
fun ContractContentScreen() {
    Column(modifier = Modifier.background(Gray50)) {
        PropertyHeaderBar(title = stringResource(id = R.string.tab3_title))
    }
}