package com.example.tenanttrack.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tenanttrack.ui.theme.Gray600

@Composable
fun FormSection(
    title: String,
    @SuppressLint("ModifierParameter")
    textModifier: Modifier = Modifier.padding(
        bottom = 8.dp,
        top = 12.dp,
        start = 16.dp,
        end = 16.dp
    ),
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyMedium.copy(
            color = Gray600,
            fontWeight = FontWeight.W600
        ),
        modifier = textModifier
    )
    Column(
        modifier = modifier,
        content = content
    )
}