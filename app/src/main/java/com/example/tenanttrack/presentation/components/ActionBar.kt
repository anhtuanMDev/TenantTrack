package com.example.tenanttrack.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tenanttrack.R
import com.example.tenanttrack.ui.theme.Gray900
import com.example.tenanttrack.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PropertyHeaderBar(
    title: String,
    showGoBack: Boolean = false,
    showActionButton: Boolean = false,
    actions: @Composable (RowScope.() -> Unit)? = null,
    onGoBack: () -> Unit = {},
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
        ),
        modifier = Modifier.shadow(4.dp),
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Gray900
            )
        },
        navigationIcon = {
            if (showGoBack) {
                IconButton(onClick = onGoBack) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_left),
                        contentDescription = "Back",
                        tint = Gray900
                    )
                }
            }
        },
        actions = {
            if (showActionButton && actions != null) {
                actions()
            }
        }
    )
}
