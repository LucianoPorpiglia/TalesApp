package com.example.storiesapp.views

import BrushedImage
import LargeText
import NormalText
import PriceBox
import PrimaryButton
import TextBottom
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.PopBackButton

@Composable
fun PaymentView(navController: NavController) {

    var selectedBox by remember { mutableIntStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        BrushedImage(imageId = R.drawable.backgroundpayment)

        PopBackButton(navController, tint = Color.White)

        LargeText(
            text = "Get Premium",
            padding = PaddingValues(top = 180.dp)
        )

        NormalText(
            text = "Unlock premium features and \n" +
                "craft unique, AI-enhanced tales.\n" +
                "\n" +
                "Dive In Now",
            padding = PaddingValues(top = 240.dp)
        )

        Box(
            modifier = Modifier
                .padding(
                    top = if (selectedBox == 0)380.dp else 430.dp,
                    start = 20.dp
                )
        ) {
            PriceBox(
                number = "1",
                text = "Monthly",
                price = "$ 2.99",
                save = "SAVE 25%",
                onClick = {
                    selectedBox = 0
                },
                isExpanded = selectedBox == 0
            )
        }

        Box(
            modifier = Modifier
                .padding(
                    top = if (selectedBox == 1)380.dp else 430.dp,
                    start = 147.5.dp
                )
        ) {
            PriceBox(
                number = "12",
                text = "Yearly",
                price = "$ 31.99",
                save = "SAVE 33%",
                onClick = {
                    selectedBox = 1
                },
                isExpanded = selectedBox == 1
            )
        }

        Box(
            modifier = Modifier
                .padding(
                    top = if (selectedBox == 2)380.dp else 430.dp,
                    start = 275.dp)
        ) {
            PriceBox(
                number = "5",
                text = "Tales",
                price = "$ 1.99",
                save = "",
                onClick = {
                    selectedBox = 2
                },
                isExpanded = selectedBox == 2
            )
        }

        TextBottom(
            text1 = "You will be abel to create",
            text2 = if(selectedBox == 2) "5 tales" else "10 tales per month"
        )

        PrimaryButton(
            onClick = {

            },
            text = "BUY NOW",
            padding = PaddingValues(start = 20.dp, end = 20.dp, top = 720.dp),
            textStyle = MaterialTheme.typography.titleMedium
        )
    }
}

