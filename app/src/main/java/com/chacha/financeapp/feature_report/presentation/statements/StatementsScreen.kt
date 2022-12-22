package com.chacha.financeapp.feature_report.presentation.statements

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chacha.financeapp.presentation.common.components.AppToolbar
import com.chacha.financeapp.presentation.common.theme.FinanceAppTheme
import com.chacha.financeapp.presentation.models.StatementEntity
import com.chacha.financeapp.presentation.models.statementEntity
import com.chacha.financeapp.presentation.screens.paybills.PayBillScreen
import com.chacha.financeapp.presentation.screens.statements.component.StatementsItem

@Composable
fun StatementsScreen(
    onClickAction: () -> Unit
) {

    StatementsContent(
        onClickAction = onClickAction

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatementsContent(
    onClickAction: () -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Statement",
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 10.dp, vertical = 16.dp)
        ) {

            LazyColumn(
                contentPadding = PaddingValues(bottom = 8.dp)
            )
            {
                items(statementEntity){ statementEntity ->
                    StatementsItem(
                        statementEntity = statementEntity,
                        onClickAction = onClickAction
                    )
                }
            }
        }

    }
}

@Composable
@Preview
fun StatementsScreenPreview() {
    FinanceAppTheme {
        StatementsScreen(
            onClickAction = {}
        )
    }

}

