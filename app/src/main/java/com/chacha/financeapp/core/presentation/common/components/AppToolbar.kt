package com.chacha.financeapp.core.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.chacha.financeapp.R
import com.chacha.financeapp.core.presentation.common.theme.FinanceAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    title: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    showBackArrow: Boolean = false,
    showForwardArrow: Boolean = false
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (showBackArrow){
                IconButton(onClick = { /* doSomething() */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "Localized description",

                    )
                }
            }
        },
        actions = {
            if (showForwardArrow){
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Message,
                        contentDescription = "Localized description"
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AppToolbarPreview() {
    FinanceAppTheme {
        AppToolbar(
            title = "Title",
            showForwardArrow = true,
            showBackArrow = true
        )
    }
}