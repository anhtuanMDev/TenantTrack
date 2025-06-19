package com.example.tenanttrack.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.tenanttrack.domain.model.ValidateUIText
import com.example.tenanttrack.domain.utils.ValidateUtils
import com.example.tenanttrack.ui.theme.Gray200
import androidx.compose.runtime.getValue
import com.example.tenanttrack.ui.theme.Gray600


@Composable
fun FormTextField(
    placeholder: String,
    text: String = "",
    onValueChange: (String) -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    modifier: Modifier,
    errorMessage: ValidateUIText? = null,
    isError: Boolean = false,
    isVisible: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = false,
    maxLine: Int = 1,
) {
    val utils = ValidateUtils()
    val isKeyboardTypeNumber =
        keyboardType == KeyboardType.Phone || keyboardType == KeyboardType.Number
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusRequester = remember {
        FocusRequester()
    }
    val colorBorder = if (isError) MaterialTheme.colorScheme.error else if (isFocused)
        MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)

    Column {
        BasicTextField(
            value = if (isKeyboardTypeNumber) {
                if (utils.isNumber(text)) text else ""
            } else text,
            onValueChange = {
                if (isKeyboardTypeNumber) {
                    if (utils.isNumber(it)) onValueChange(it)
                } else onValueChange(it)
            },
            textStyle = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
            maxLines = maxLine,
            singleLine = singleLine,
            interactionSource = interactionSource,
            visualTransformation =
                if (keyboardType == KeyboardType.Password) {
                    if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(8.dp),
                            color = colorBorder
                        )
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .focusRequester(focusRequester)
                ) {
                    if (leadingIcon != null) {
                        leadingIcon()
                    } else {
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                    Box(
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(vertical = 16.dp)
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = MaterialTheme.typography.bodySmall,
                                color = Gray600,
                            )
                        }
                        Box(modifier = Modifier.fillMaxWidth()) {
                            innerTextField()
                        }
                    }
                    if (trailingIcon != null) {
                        trailingIcon()
                    } else {
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            },
        )
        Text(
            text = if (isError) errorMessage!!.asString(context) else "",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = modifier
        )
    }
}


/*
* Password usage
*
*CustomTextFieldApp(
    placeholder = stringResource(id = R.string.strPassword),
    text = viewModel.formState.password,
    onValueChange = {
        viewModel.onEvent(MainEvent.PasswordChanged(it))
    },
    keyboardType = KeyboardType.Password,
    ImeAction.Done,
    trailingIcon = {
        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
            IconButton(
                onClick =
                {
                    viewModel.onEvent(MainEvent.VisiblePassword(!(viewModel.formState.isVisiblePassword)))
                }
            ) {
                Icon(
                    painter = if (viewModel.formState.isVisiblePassword) painterResource(
                        id = R.drawable.ic_visible
                    ) else painterResource(
                        id = R.drawable.ic_invisible
                    ),
                    contentDescription = "Visible",
                    tint = colorSilver,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    },
    isVisible = viewModel.formState.isVisiblePassword,
    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
    singleLine = true,
    isError = viewModel.formState.passwordError != null,
    errorMessage = viewModel.formState.passwordError
)
*
* */