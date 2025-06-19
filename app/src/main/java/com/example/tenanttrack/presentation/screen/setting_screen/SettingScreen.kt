package com.example.tenanttrack.presentation.screen.setting_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tenanttrack.R
import com.example.tenanttrack.presentation.components.PropertyHeaderBar
import com.example.tenanttrack.ui.theme.Gray100
import com.example.tenanttrack.ui.theme.Gray50
import com.example.tenanttrack.ui.theme.Gray900
import com.example.tenanttrack.ui.theme.White

@Composable
fun SettingScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        SettingContentScreen()
    }
}

@Composable
fun SettingContentScreen() {
    val sections = provideSettingSections()

    Column(modifier = Modifier.background(Gray50)) {
        PropertyHeaderBar(title = stringResource(id = R.string.tab4_title))
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 180.dp)
        ) {
            sections.forEach { section ->
                Section(title = section.title) {
                    section.items.forEachIndexed { index, item ->
                        SettingsCard(
                            icon = item.icon,
                            title = item.title,
                            subtitle = item.subtitle,
                            tint = item.tint,
                            backgroundIcon = item.backgroundIcon,
                            trailingIcon = item.trailingIcon,
                            onPress = item.onPress
                        )
                        if (index < section.items.lastIndex) {
                            Divider()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Divider() {
    Spacer(modifier = Modifier
        .height(2.dp)
        .fillMaxWidth()
        .background(Gray100))
}


@Composable
fun Section(title: String, content: @Composable ColumnScope.() -> Unit) {
    Text(
        text = title,
        style = TextStyle(fontWeight = FontWeight.Bold, color = Gray900, fontSize = 18.sp),
        modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
    )
    Column(
        content = content, modifier = Modifier
            .shadow(
                elevation = 2.dp, // Adjust for shadow depth
                shape = RoundedCornerShape(12.dp), // Required for shadow
                clip = false // Important: true clips content to shape
            )
            .clip(RoundedCornerShape(12.dp))
    )
}

@Composable
fun SettingsCard(
    icon: Int,
    title: String,
    subtitle: String,
    tint: Color = Color.Unspecified,
    trailingIcon: Int? = R.drawable.chevron_right,
    backgroundIcon: Color = Color(0xFFF5F5F5),
    onPress: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
        onClick = onPress
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = tint,
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = backgroundIcon,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            if (trailingIcon != null) {
                Icon(
                    painter = painterResource(id = trailingIcon),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
