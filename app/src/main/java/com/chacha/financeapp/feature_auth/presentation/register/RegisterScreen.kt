package com.chacha.financeapp.feature_auth.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chacha.financeapp.R
import com.chacha.financeapp.core.presentation.common.components.AppToolbar
import com.chacha.financeapp.core.presentation.common.components.FinanceOutlinedTextField
import com.chacha.financeapp.core.presentation.common.theme.FinanceAppTheme
import com.chacha.financeapp.core.util.UiEvents

@Composable
fun RegisterScreen(
    onClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    RegisterContent(
        onClick = onClick,
        onLoginClick = onLoginClick
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterContent(
    onClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val (email, setEmail) = rememberSaveable { mutableStateOf("") }
    val (mobileNumber, setMobileNumber) = rememberSaveable { mutableStateOf("") }
    val (idNumber, setIdNumber) = rememberSaveable { mutableStateOf("") }
    Scaffold (
        topBar = {
            AppToolbar(
                title = "Register",
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
                        value = email,
                        onValueChange = { setEmail(it) },
                        hint = stringResource(id = R.string.email_hint),
                        keyboardType = KeyboardType.Email
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FinanceOutlinedTextField(
                        value = mobileNumber,
                        onValueChange = { setMobileNumber(it) },
                        hint = stringResource(id = R.string.mobile_number_hint),
                        keyboardType = KeyboardType.Phone
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FinanceOutlinedTextField(
                        value = idNumber,
                        onValueChange = { setIdNumber(it) },
                        hint = stringResource(id = R.string.id_number_hint),
                        keyboardType = KeyboardType.Number
                    )

                    /* Button */

                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        OutlinedButton(
                            onClick = { onClick() },
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                        ) {
                            Text(
                                text = "Register",
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { onLoginClick() },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                            enabled = false
                        ) {
                            Text(
                                text = "Login",
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
fun RegisterScreenPreview() {
    FinanceAppTheme {
        RegisterScreen(
            onClick = {},
            onLoginClick = {}
        )
    }
}
