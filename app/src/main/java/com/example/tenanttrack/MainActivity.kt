package com.example.tenanttrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.tenanttrack.presentation.screen.navigation.RootNavGraph
import com.example.tenanttrack.ui.theme.TenantTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TenantTrackTheme {
                val navController = rememberNavController()
                RootNavGraph(navController)
            }
        }
    }
}