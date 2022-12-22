package com.chacha.financeapp.feature_transaction.presentation.transaction

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.service.autofill.OnClickAction
import android.service.autofill.UserData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.chacha.financeapp.R
import com.chacha.financeapp.presentation.common.theme.FinanceAppTheme

@Composable
fun TransactionScreen(
    onClickAction: () -> Unit
) {
    TransactionContent(
        onClickAction = onClickAction
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionContent(
    onClickAction: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(text =stringResource(id = R.string.transaction))
                },
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 10.dp, vertical = 16.dp)
        ) {


        }

    }
}

@Composable
fun SubmitButton(
    onClickAction: () -> Unit
) {
    val submitButtonColor = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.onBackground,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
    Button(
        onClick = onClickAction,
        modifier = Modifier.padding(16.dp),
        colors = submitButtonColor
    ) {
        Text(
            text = stringResource(id = R.string.submit),
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun UserProfile(
    userProfile: UserProfile
) {
    Column (modifier = Modifier.padding(horizontal = 24.dp)){
        AsyncImage(
            model = userProfile.imageUrl,
            contentDescription =
            stringResource(id = R.string.user_profile),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .size(100.dp)
                .clip(CircleShape),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )

        Row {
            Text(text = userProfile.name)

            IconButton(onClick = { /*TODO*/ }) {
                   Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit"
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        }

    }
}

data class UserProfile(
    val imageUrl: String,
    val name: String
)

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "phone", device =
"spec: shape = Normal, width = 360, height = 640, density = 3.0")
@Preview(name = "small tablet", device = "spec: shape = Normal, width = 600, height = 1024, density = 2.0")
@Composable
fun SubmitButtonPreview() {
    FinanceAppTheme {
        SubmitButton(
            onClickAction = { }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = UI_MODE_NIGHT_YES)
fun TransactionScreenPreview() {
    FinanceAppTheme {
        TransactionScreen(
            onClickAction = {

            }
        )
    }
}