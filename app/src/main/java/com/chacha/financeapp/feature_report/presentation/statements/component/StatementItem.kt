package com.chacha.financeapp.feature_report.presentation.statements.component

import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chacha.financeapp.R
import com.chacha.financeapp.presentation.common.theme.FinanceAppTheme
import com.chacha.financeapp.presentation.models.StatementEntity

@Composable
fun StatementsItem(
    statementEntity: StatementEntity,
    onClickAction: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        Image(
            painter = painterResource(id = statementEntity.transactionIcon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape),
        )
        Column(
            modifier = Modifier.padding(start = 10.dp, end = 0.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = statementEntity.transactionName,
                maxLines = 2,
                fontSize = 11.sp,
                overflow = TextOverflow.Clip,
                modifier = Modifier.padding(end = 10.dp)

            )
            Text(
                text = statementEntity.transactionNumber,
                fontSize = 11.sp,
                modifier = Modifier.padding(end = 10.dp)


            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = statementEntity.transactionAmount,
                fontSize = 11.sp,
                overflow = TextOverflow.Clip,


            )
            Text(
                text = statementEntity.transactionTime,
                fontSize = 11.sp

            )
        }

    }

}

@Composable
@Preview
fun StatementItemPreview() {
    FinanceAppTheme {
        StatementsItem(
            statementEntity = StatementEntity(
                R.drawable.icon_loan,
                "Stepheuuuuuuuuuuu  iiiiikkkkkkkkuuharito",
                "0756565656",
                "1000",
                "12-Dec-2022"
            ),
            onClickAction = {}
        )
    }

}