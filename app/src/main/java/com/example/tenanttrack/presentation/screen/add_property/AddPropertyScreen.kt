package com.example.tenanttrack.presentation.screen.add_property

import android.app.Activity
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.tenanttrack.R
import com.example.tenanttrack.data.local.entities.PropertyModelType
import com.example.tenanttrack.data.local.entities.PropertyStatus
import com.example.tenanttrack.domain.model.PropertyFormEvent
import com.example.tenanttrack.domain.utils.CropUtils
import com.example.tenanttrack.presentation.components.FilterChips
import com.example.tenanttrack.presentation.components.FormTextField
import com.example.tenanttrack.presentation.components.PropertyHeaderBar
import com.example.tenanttrack.presentation.viewmodel.PropertyFormViewModel
import com.example.tenanttrack.ui.theme.Blue
import com.example.tenanttrack.ui.theme.Gray200
import com.example.tenanttrack.ui.theme.Gray600

@Composable
fun AddPropertyScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        AddPropertyBody(onGoBack = { navController.popBackStack() })
    }
}

@Composable
fun AddPropertyBody(onGoBack: () -> Unit, viewModel: PropertyFormViewModel = viewModel()) {
    val listStatus = PropertyStatus.entries.map { stringResource(id = it.label) }
    val listModelType = PropertyModelType.entries.map { stringResource(id = it.label) }
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val cropLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val croppedUri = CropUtils.getCroppedUri(result.data)
            imageUri = croppedUri
        }
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val cropIntent = CropUtils.getCropIntent(context, it)
            cropLauncher.launch(cropIntent)
        }
    }
    Column {
        PropertyHeaderBar(
            title = stringResource(id = R.string.header_add_property),
            showActionButton = true,
            showGoBack = true,
            back = {
                Text(
                    text = stringResource(id = R.string.option_cancel),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.W600,
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable { onGoBack() }
                        .shadow(0.dp),
                )
            },
            actions = {
                Text(
                    text = stringResource(id = R.string.option_save),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.W600,
                    ),
                    modifier = Modifier.padding(end = 16.dp)
                )
            },
        )

        SectionTile(
            title = stringResource(id = R.string.add_property_title1),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            FormTextField(
                placeholder = stringResource(id = R.string.add_property_placeholder1),
                text = viewModel.state.name,
                onValueChange = {
                    viewModel.onEvent(PropertyFormEvent.NameChanged(it))
                },
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = viewModel.state.nameError != null,
                errorMessage = viewModel.state.nameError,
            )
        }

        SectionTile(title = stringResource(id = R.string.add_property_title2)) {
            FilterChips(categories = listModelType, selectedCategory = "Hut") { }
        }

        SectionTile(
            title = stringResource(id = R.string.add_property_title3),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            FormTextField(
                placeholder = stringResource(id = R.string.add_property_placeholder3),
                text = viewModel.state.address,
                onValueChange = {
                    viewModel.onEvent(PropertyFormEvent.AddressChanged(it))
                },
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                modifier = Modifier.fillMaxWidth(),
                singleLine = false,
                maxLine = 2,
                minLine = 2,
                isError = viewModel.state.addressError != null,
                errorMessage = viewModel.state.addressError,
            )
        }

        SectionTile(
            title = stringResource(id = R.string.add_property_title4),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            FormTextField(
                placeholder = stringResource(id = R.string.add_property_placeholder4),
                text = viewModel.state.totalRoom,
                onValueChange = {
                    viewModel.onEvent(PropertyFormEvent.TotalRoomChange(it))
                },
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = viewModel.state.totalRoomError != null,
                errorMessage = viewModel.state.totalRoomError,
            )
        }

        SectionTile(title = stringResource(id = R.string.add_property_title5)) {
            FilterChips(categories = listStatus, selectedCategory = "Maintained") { }
        }

        SectionTile(
            title = stringResource(id = R.string.add_property_title6),
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .clickable {
                        launcher.launch("image/*")
                    }
            ) {
                if (imageUri != null) {
                    AsyncImage(
                        model = imageUri,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.camera),
                        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                        contentDescription = null
                    )
                    Text(
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            fontWeight = FontWeight.W700
                        ),
                        modifier = Modifier.padding(top = 8.dp),
                        text = stringResource(id = R.string.add_property_placeholder6)
                    )
                }
            }
        }
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
        style = MaterialTheme.typography.bodyMedium.copy(
            color = Gray600,
            fontWeight = FontWeight.W600
        ),
        modifier = Modifier.padding(bottom = 8.dp, top = 12.dp, start = 16.dp, end = 16.dp)
    )
    Column(
        modifier = modifier,
        content = content
    )
}