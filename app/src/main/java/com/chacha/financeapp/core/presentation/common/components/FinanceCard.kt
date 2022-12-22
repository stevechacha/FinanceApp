package com.chacha.financeapp.core.presentation.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chacha.financeapp.core.presentation.common.theme.FinanceAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinanceCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        onClick = { onClick()},
        modifier = modifier.size(width = 180.dp, height = 100.dp)
    ) {
        Box(modifier.fillMaxSize()) {
            Text("Clickable", modifier.align(Alignment.Center))
        }
    }

}


@Composable
@Preview
fun FinanceCardPreview() {
    FinanceAppTheme {
        FinanceCard(onClick = { /*TODO*/ }) {

        }
    }
}