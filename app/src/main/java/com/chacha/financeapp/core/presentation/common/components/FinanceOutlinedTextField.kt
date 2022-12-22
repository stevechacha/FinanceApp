package com.chacha.financeapp.core.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chacha.financeapp.R
import com.chacha.financeapp.core.presentation.common.util.TestTags

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinanceOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    textStyle: TextStyle = LocalTextStyle.current,
    isError: Boolean = false,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int = 50,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    error: String = "",
    trailingIcon: (@Composable () -> Unit)? = null,
    supportTextHeader: String?=null

    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            placeholder = {
                Text(text = hint)
            },
            label = {
                Text(text = hint)
            },
            supportingText = {
                if (supportTextHeader != null) {
                    Text(text = supportTextHeader )
                }
            },
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            leadingIcon = if (leadingIcon != null) {
                val icon: @Composable () -> Unit = {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else null,
            trailingIcon = if (isPasswordToggleDisplayed) {
                val icon: @Composable () -> Unit = {
                    IconButton(
                        onClick = {
                            onPasswordToggleClick(!isPasswordVisible)
                        },
                        modifier = Modifier
                            .semantics {
                                testTag = TestTags.PASSWORD_TOGGLE
                            }
                    ) {
                        Icon(
                            imageVector = if (!isPasswordVisible) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            contentDescription = if (isPasswordVisible) {
                                stringResource(id = R.string.password_visible_content_description)
                            } else {
                                stringResource(id = R.string.password_hidden_content_description)
                            },
                            modifier = Modifier.padding(end = 10.dp)
                        )
                    }
                }
                icon
            } else null,
            colors = TextFieldDefaults.outlinedTextFieldColors(),
            modifier = modifier
                .fillMaxWidth()
                .semantics {
                    testTag = TestTags.STANDARD_TEXT_FIELD
                },
            textStyle = textStyle,
            isError = isError,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            )


}

@Preview
@Composable
fun FinanceOutlinedTextFieldPreview() {
    FinanceOutlinedTextField(
        value = "Hello",
        onValueChange = {},
        hint = "Hint",
        supportTextHeader = "SupportTextHeader",
        trailingIcon = {
            Image(
                imageVector = Icons.Filled.Message,
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }

    )
}