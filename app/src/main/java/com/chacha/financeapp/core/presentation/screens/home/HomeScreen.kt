package com.chacha.financeapp.core.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.chacha.financeapp.R
import com.chacha.financeapp.presentation.common.theme.FinanceAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickAction: () -> Unit
) {
    Scaffold(
        topBar = {
            HomeToolbar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            BalanceCard()
            Spacer(modifier = Modifier.height(16.dp))
            HomeServices()
        }

    }
}


@Composable
fun HomeToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(start = 20.dp, end = 20.dp, top = 19.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Welcome Back !")
            Text(text = "Stephen Chacha")
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.loan_icon) , 
            contentDescription = null
        )
    }
}

@Composable
fun BalanceCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Current Balance"
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "200000"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(painter = painterResource(id = R.drawable.loan_icon),
                    contentDescription = "Current Balance",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                )

                Image(painter = painterResource(id = R.drawable.loan_icon),
                    contentDescription = "Current Balance",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.onSecondaryContainer)

                )
                Image(painter = painterResource(id = R.drawable.loan_icon),
                    contentDescription = "Current Balance",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.onBackground)

                )
                Image(painter = painterResource(id = R.drawable.loan_icon),
                    contentDescription = "Current Balance",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                )
            }
        }

    }

}

@Composable
fun Profile(user: User){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        val (image, text) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.loan_icon),
            contentDescription = "Profile",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = "Profile",
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(image.end)
                }
        )

        if (user.title != null) {
            Text(
                text = user.title.substring(0,2),
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(image.end)
                    }
            )
        } else{

            AsyncImage(
                model = user.title ,
                contentDescription = "user",
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(image.end)
                    }
            )


        }
    }
}

data class User (
    val title: String? = null,
    val icon: Int
    )

@Composable
fun HomeServices() {
    HomeServiceComponent()

}

@Composable
fun HomeServiceComponent() {
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(120.dp)
            .padding(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            val (image, nameText) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.home_icon ),
                contentDescription =  null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(40.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = "Name",
                modifier = Modifier
                    .constrainAs(nameText){
                        top.linkTo(image.bottom, margin = 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

        }

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    FinanceAppTheme {
        HomeScreen {

        }
    }
}