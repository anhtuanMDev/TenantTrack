package com.example.tenanttrack.presentation.add_property

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tenanttrack.R
import com.example.tenanttrack.data.local.entities.PropertyModelType
import com.example.tenanttrack.data.local.entities.PropertyStatus
import com.example.tenanttrack.presentation.components.FilterChips
import com.example.tenanttrack.presentation.components.PropertyHeaderBar
import com.example.tenanttrack.ui.theme.Blue
import com.example.tenanttrack.ui.theme.Gray200
import com.example.tenanttrack.ui.theme.Gray50
import com.example.tenanttrack.ui.theme.Gray600
import com.example.tenanttrack.ui.theme.Gray900
import com.example.tenanttrack.ui.theme.White

@Composable
fun AddPropertyScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        AddPropertyBody(onGoBack = { navController.popBackStack() })
    }
}

@Composable
fun AddPropertyBody(onGoBack: () -> Unit) {
    val listStatus = PropertyStatus.entries.map { stringResource(id = it.label) }
    val listModelType = PropertyModelType.entries.map { stringResource(id = it.label) }
    Column {
        PropertyHeaderBar(
            title = stringResource(id = R.string.header_add_property),
            showActionButton = true,
            showGoBack = true,
            back = {
                Text(
                    text = stringResource(id = R.string.option_cancel),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable { onGoBack() }
                        .shadow(0.dp),
                )
            },
            actions = {
                Text(
                    text = stringResource(id = R.string.option_save),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue,
                    modifier = Modifier.padding(end = 16.dp)
                )
            },
        )

        SectionTile(
            title = stringResource(id = R.string.add_property_title1),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            TextField(
                value = "",
                placeholder = { Text(text = stringResource(R.string.add_property_placeholder1)) },
                onValueChange = {},
                singleLine = true,
                textStyle = TextStyle(
                    fontWeight = FontWeight.W500,
                    color = Gray900,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .background(White)
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(1.dp, Gray200),
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Gray50,
                    focusedContainerColor = White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
        }

        SectionTile(title = stringResource(id = R.string.add_property_title2)) {
            FilterChips(categories = listModelType, selectedCategory = "Hut") { }
        }

        SectionTile(
            title = stringResource(id = R.string.add_property_title3),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            TextField(
                value = "",
                placeholder = { Text(text = stringResource(R.string.add_property_placeholder3)) },
                onValueChange = {},
                textStyle = TextStyle(
                    fontWeight = FontWeight.W500,
                    color = Gray900,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .background(White)
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(1.dp, Gray200),
                        shape = RoundedCornerShape(8.dp)
                    ),
                maxLines = 2,
                minLines = 2,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Gray50,
                    focusedContainerColor = White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
        }

        SectionTile(
            title = stringResource(id = R.string.add_property_title4),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            TextField(
                value = "",
                placeholder = { Text(text = stringResource(R.string.add_property_placeholder4)) },
                onValueChange = {},
                textStyle = TextStyle(
                    fontWeight = FontWeight.W500,
                    color = Gray900,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .background(White)
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(1.dp, Gray200),
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Gray50,
                    focusedContainerColor = White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
        }

        SectionTile(title = stringResource(id = R.string.add_property_title5)) {
            FilterChips(categories = listStatus, selectedCategory = "Maintained") { }
        }

        SectionTile(
            title = stringResource(id = R.string.add_property_title6),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {}
    }
}

@Composable
fun SectionTile(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Text(
        text = title,
        style = TextStyle(fontWeight = FontWeight.W700, color = Gray600, fontSize = 16.sp),
        modifier = Modifier.padding(bottom = 8.dp, top = 20.dp, start = 16.dp, end = 16.dp)
    )
    Column(
        modifier = modifier,
        content = content
    )
}