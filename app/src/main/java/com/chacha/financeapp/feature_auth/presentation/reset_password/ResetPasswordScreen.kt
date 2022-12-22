package com.chacha.financeapp.feature_auth.presentation.reset_password

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chacha.financeapp.R
import com.chacha.financeapp.presentation.common.components.AppToolbar
import com.chacha.financeapp.presentation.common.components.FinanceOutlinedTextField
import com.chacha.financeapp.presentation.common.theme.FinanceAppTheme
import com.chacha.financeapp.feature_auth.presentation.create_password.CreatePasswordViewModel

@Composable
fun ResetPasswordScreen(
    onClickAction: () -> Unit
) {
    ResetPasswordContent(
        viewModel = CreatePasswordViewModel(),
        onClickAction = onClickAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordContent(
    onClickAction: () -> Unit,
    viewModel: CreatePasswordViewModel
) {
    val (currentPassword, setCurrentPassword) = rememberSaveable { mutableStateOf("") }
    val (newPassword, setNewPassword) = rememberSaveable { mutableStateOf("") }
    val (confirmNewPassword, setConfirmNewPassword) = rememberSaveable { mutableStateOf("") }
    Scaffold (
        topBar = {
            AppToolbar(
                title = "Reset Password",
                showForwardArrow = true,
                showBackArrow = true
            )
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column {

                    FinanceOutlinedTextField(
                        value = currentPassword,
                        onValueChange = { setCurrentPassword(it) },
                        hint = stringResource(id = R.string.current_password),
                        keyboardType = KeyboardType.Password,
                        error = viewModel.passwordError.value,
                        isPasswordVisible = viewModel.showPassword.value,
                        onPasswordToggleClick = {
                            viewModel.setShowPassword(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FinanceOutlinedTextField(
                        value = newPassword,
                        onValueChange = { setNewPassword(it) },
                        keyboardType = KeyboardType.Password,
                        hint = stringResource(id = R.string.new_password),
                        error = viewModel.passwordError.value,
                        isPasswordVisible = viewModel.showPassword.value,
                        onPasswordToggleClick = {
                            viewModel.setShowPassword(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FinanceOutlinedTextField(
                        value = confirmNewPassword,
                        onValueChange = { setConfirmNewPassword(it) },
                        keyboardType = KeyboardType.Password,
                        hint = stringResource(id = R.string.confirmNewPassword),
                        error = viewModel.passwordError.value,
                        isPasswordVisible = viewModel.showConfirmPassword.value,
                        onPasswordToggleClick = {
                            viewModel.setShowConfirmPassword(it)
                        }
                    )

                    /* Button */

                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        Button(
                            onClick = { onClickAction() },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                        ) {
                            Text(
                                text = "Continue",
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }

        }
    }
}

@Composable
@Preview
fun ResetPasswordScreenPreview() {
    FinanceAppTheme {
        ResetPasswordScreen(
            onClickAction = {}
        )
    }
}
