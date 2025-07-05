package com.example.tenanttrack.presentation.screen.add_room

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tenanttrack.R
import com.example.tenanttrack.presentation.components.FormSection
import com.example.tenanttrack.presentation.components.PropertyHeaderBar

@Composable
fun AddTenantScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        AddTenantBody(onGoBack = { navController.popBackStack() })
    }
}

@Composable
fun AddTenantBody(onGoBack: () -> Unit) {
    val shapeRound = RoundedCornerShape(32.dp)
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        PropertyHeaderBar(
            title = stringResource(id = R.string.header_add_tenant),
            showActionButton = true,
            showGoBack = true,
            back = {
                IconButton(onClick = onGoBack, modifier = Modifier.padding(start = 16.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_left),
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = onGoBack, modifier = Modifier.padding(start = 16.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.info),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(top = 24.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.add_tenant_header),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.W700,
                    color = MaterialTheme.colorScheme.onBackground
                ),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = shapeRound
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = shapeRound
                    )
                    .padding(vertical = 8.dp, horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.add_tenant_helper_like_main),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {}, modifier = Modifier
                    .size(60.dp)
                    .background(
                        MaterialTheme.colorScheme.onSurfaceVariant,
                        shape = RoundedCornerShape(60.dp)
                    )
                    .clip(RoundedCornerShape(60.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        FormSection(title = stringResource(id = R.string.add_tenant_title1)) { }
        FormSection(title = stringResource(id = R.string.add_tenant_title2)) { }
        FormSection(title = stringResource(id = R.string.add_tenant_title3)) { }
        FormSection(title = stringResource(id = R.string.add_tenant_title4)) { }
        FormSection(title = stringResource(id = R.string.add_tenant_title5)) { }
    }
}



