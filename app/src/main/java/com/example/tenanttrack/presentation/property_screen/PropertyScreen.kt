package com.example.tenanttrack.presentation.property_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tenanttrack.R
import com.example.tenanttrack.data.local.entities.PropertyModelType
import com.example.tenanttrack.presentation.components.FilterChips
import com.example.tenanttrack.presentation.components.PropertyHeaderBar
import com.example.tenanttrack.presentation.components.SearchBar
import com.example.tenanttrack.ui.theme.Blue
import com.example.tenanttrack.ui.theme.Gray400
import com.example.tenanttrack.ui.theme.Gray50
import com.example.tenanttrack.ui.theme.Red
import com.example.tenanttrack.ui.theme.Success

@Composable
fun PropertyScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        PropertyContentScreen()
    }
}

@Composable
fun PropertyContentScreen() {
    var searchText by remember { mutableStateOf("") }
    val categories: List<String> = listOf("All") + PropertyModelType.entries.map { it.name }
    var category by remember { mutableStateOf("All") }

    Column(modifier = Modifier.background(Gray50)) {
        PropertyHeaderBar(
            title = stringResource(id = R.string.tab1_title),
            showActionButton = true,
            actions = {
                IconButton(onClick = { /* handle search */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.funnel),
                        contentDescription = "Search"
                    )
                }
            })
        SearchBar(
            text = searchText,
            onTextChange = { searchText = it },
            placeholder = stringResource(id = R.string.tab1_search_placeholder)
        )

        FilterChips(
            categories = categories,
            selectedCategory = category,
            onCategorySelected = { category = it }
        )
    }
}


@Composable
fun PropertyItemHeader() {
}

@Composable
fun PropertyItemCard() {
    Card(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp),
        elevation = CardDefaults.cardElevation(8.dp), // ✅ Add shadow
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier.padding(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(Success)
                            .shadow(
                                6.dp,
                                shape = CircleShape,
                                ambientColor = Success,
                                spotColor = Success
                            )
                    )
                }
            }

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(12.dp)
            ) {
                Text(
                    text = "Name",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.map_pin),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = "Address",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp),
                        color = Gray400
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.padding(bottom = 8.dp)) {
                    Row {
                        Text(
                            text = "8",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Blue
                        )
                        Text(text = " of 12", fontSize = 14.sp, color = Gray400)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "$48000",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Success
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    LinearProgressIndicator(
                        progress = { 0.2f },
                        modifier = Modifier.weight(1f),
                        color = Red,
                        trackColor = Blue,
                        strokeCap = StrokeCap.Round
                    )
                    Text(
                        text = "30%",
                        fontSize = 14.sp,
                        color = Gray400,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}