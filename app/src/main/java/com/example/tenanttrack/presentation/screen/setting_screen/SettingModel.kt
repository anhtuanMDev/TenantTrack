package com.example.tenanttrack.presentation.screen.setting_screen

import androidx.compose.ui.graphics.Color
import com.example.tenanttrack.R

data class SettingItem(
    val icon: Int,
    val title: String,
    val subtitle: String,
    val tint: Color = Color.Unspecified,
    val backgroundIcon: Color = Color(0xFFF5F5F5),
    val trailingIcon: Int? = R.drawable.chevron_right,
    val onPress: () -> Unit = {}
)

data class SettingSection(
    val title: String,
    val items: List<SettingItem>
)
