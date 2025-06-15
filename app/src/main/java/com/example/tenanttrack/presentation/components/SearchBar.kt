package com.example.tenanttrack.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tenanttrack.R
import com.example.tenanttrack.ui.theme.Gray100
import com.example.tenanttrack.ui.theme.Gray400
import com.example.tenanttrack.ui.theme.Gray900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(id = R.string.empty_string)
) {
    val focusManager = LocalFocusManager.current
    val insets = WindowInsets.ime
    val imeVisible = insets.getBottom(LocalDensity.current) > 0

    LaunchedEffect(imeVisible) {
        if (!imeVisible) {
            focusManager.clearFocus()
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 16.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Gray100)
            .padding(start = 12.dp, end = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "Search",
            tint = Gray400,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        BasicTextField(
            value = text,
            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Gray900),
            onValueChange = onTextChange,
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            decorationBox = { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = text,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = remember { MutableInteractionSource() },
                    contentPadding = PaddingValues(0.dp),
                    placeholder = {
                        Text(text = placeholder, color = Gray400)
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Gray100,
                        focusedContainerColor = Gray100,
                        disabledContainerColor = Gray100,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        if (text.isNotEmpty()) {
            IconButton(onClick = { onTextChange("") }) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = Gray400,
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(45f)
                )
            }
        }
    }
}
