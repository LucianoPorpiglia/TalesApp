package com.example.storiesapp.views

import NormalText
import PrimaryButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.MainLogo
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.components.StarIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendFeedbackView(navController: NavController){

    var filledStar by remember { mutableIntStateOf(0) }
    var note by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )   {

        Box(modifier = Modifier.fillMaxWidth()) {
            PopBackButton(navController, tint = Color.Black)
        }

        MainLogo(padding = PaddingValues(top = 20.dp), size = 125.dp)

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            repeat(5) { fillStar ->
                StarIcon(
                    onClick = {
                        filledStar = fillStar + 1
                    },
                    isFilled = fillStar < filledStar
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 25.dp),
            text = "We appreciate your feedback! Please share what you \n" +
                    "enjoy and any area for improvement in the app. Your \n" +
                    "insights are invaluable to help us to enhance your \n" +
                    "experience.",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            label = { Text(
                text = "",
                style = MaterialTheme.typography.titleSmall,
            ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(150.dp)
        )

        PrimaryButton(
            onClick = {},
            padding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp),
            text = "Send",
            textStyle = MaterialTheme.typography.titleSmall
        )
    }
}