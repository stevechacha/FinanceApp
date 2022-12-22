package com.chacha.financeapp.feature_loan.presentation.loan

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoanScreen(
    navigateToLogin:() -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ToLogin",
            modifier = Modifier.clickable { navigateToLogin() }
        )

    }


}

@Composable
fun Accoun(
    navigateToLogin: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ToLogin",
            modifier = Modifier.clickable {  }
        )

    }
}