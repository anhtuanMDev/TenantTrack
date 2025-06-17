package com.example.tenanttrack.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tenanttrack.ui.theme.Gray600
import com.example.tenanttrack.ui.theme.Gray900
import com.example.tenanttrack.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PropertyHeaderBar(
    title: String,
    showGoBack: Boolean = false,
    showActionButton: Boolean = false,
    actions: @Composable (RowScope.() -> Unit)? = null,
    back: @Composable () -> Unit = {},
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
        ),
        modifier = Modifier.shadow(4.dp),
        title = {
            if (showGoBack && showActionButton) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Gray600
                    )
                }

            } else {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Gray900
                )
            }
        },
        navigationIcon = {
            if (showGoBack) {
//                IconButton(onClick = onGoBack) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.chevron_left),
//                        contentDescription = "Back",
//                        tint = Gray900
//                    )
//                }
                back()
            }
        },
        actions = {
            if (showActionButton && actions != null) {
                actions()
            }
        }
    )
}
