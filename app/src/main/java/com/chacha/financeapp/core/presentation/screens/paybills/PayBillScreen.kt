package com.chacha.financeapp.core.presentation.screens.paybills

import android.service.autofill.OnClickAction
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chacha.financeapp.R
import com.chacha.financeapp.core.presentation.common.components.AppToolbar
import com.chacha.financeapp.core.presentation.common.components.FinanceOutlinedTextField
import com.chacha.financeapp.core.presentation.common.theme.FinanceAppTheme
import com.chacha.financeapp.core.presentation.models.payBillDetails
import com.chacha.financeapp.core.presentation.screens.paybills.component.PayBillComponent

@Composable
fun PayBillScreen(
    onClickAction: () -> Unit
) {
    PayBillContent(
        onClickAction = onClickAction
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayBillContent(
    onClickAction: () -> Unit
) {
    val (payBillNumber, setPayBillNumber) = rememberSaveable { mutableStateOf("") }
    val (accountNumber, setAccountNumber) = rememberSaveable { mutableStateOf("") }
    val (amount, setAmount) = rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            AppToolbar(
                title = "PayBill",
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
            FinanceOutlinedTextField(
                value = payBillNumber ,
                onValueChange = setPayBillNumber,
                hint =  stringResource(id = R.string.payBillNumber),
                keyboardType = KeyboardType.Number,
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            FinanceOutlinedTextField(
                value = accountNumber ,
                onValueChange = setAccountNumber,
                hint =  stringResource(id = R.string.accountNumber),
                keyboardType = KeyboardType.Number,
            )

            Spacer(modifier = Modifier.height(16.dp))

            FinanceOutlinedTextField(
                value = amount ,
                onValueChange = setAmount,
                hint =  stringResource(id = R.string.payBillAmount),
                keyboardType = KeyboardType.Number,
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(),
                shape = RoundedCornerShape(8)
            ) {
                Text(
                    text = "Continue",
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Frequent",
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                contentPadding = PaddingValues(bottom = 40.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(payBillDetails) {  payBillDetails ->
                    PayBillComponent(
                        payBillDetails = payBillDetails,
                        onClickAction = onClickAction
                    )
                    Divider(color = Color.Black, thickness = 1.dp)

                }
            }

        }

    }
}

@Composable
@Preview
fun PayBillScreenPreview() {
    FinanceAppTheme {
        PayBillScreen(
            onClickAction = {}
        )
    }

}
