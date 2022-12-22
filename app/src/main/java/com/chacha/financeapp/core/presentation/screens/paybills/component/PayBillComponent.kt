package com.chacha.financeapp.core.presentation.screens.paybills.component

import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chacha.financeapp.R
import com.chacha.financeapp.presentation.common.theme.FinanceAppTheme
import com.chacha.financeapp.presentation.models.PayBillDetails

@Composable
fun PayBillComponent(
    modifier: Modifier = Modifier,
    payBillDetails: PayBillDetails,
    onClickAction: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = payBillDetails.icon),
            contentDescription = payBillDetails.payBillName,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(25.dp)
                .clip(CircleShape)

        )
        Column(modifier = modifier.padding(start = 8.dp)) {
            Text(
                text = payBillDetails.payBillName,
                fontSize = 12.sp
            )
            Text(
                text = payBillDetails.payBillNumber.toString(),
                fontSize = 12.sp
            )
        }
    }



}

@Composable
@Preview
fun PayBillComponentPreview() {
    FinanceAppTheme {
        PayBillComponent(
            payBillDetails = PayBillDetails(
                123456,
                R.drawable.loan_icon,
                "Equity Bank"
            ),
            onClickAction = {}
        )
    }
}