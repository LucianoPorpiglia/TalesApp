package com.example.storiesapp.views

import PrimaryButton
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.CharacterItem
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.components.PrincipalTitle
import com.example.storiesapp.components.RandomButton
import com.example.storiesapp.components.SkipButton
import com.example.storiesapp.components.TextClickable
import com.example.storiesapp.components.TransparentButton
import com.example.storiesapp.components.imagesArray

@Composable
fun MainCharacterView(navController: NavController) {

    val characters = imagesArray()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box {
            PopBackButton(navController, tint = Color.Black)

            Text(
                text = "Choose",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            PrincipalTitle(text = "Main Character")

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
            ) {
                items(characters) { character ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .size(height = 550.dp, width = 350.dp)
                            .border(3.dp, Color.Red, shape = RoundedCornerShape(10.dp))
                    ) {

                        CharacterItem(character)

                        TransparentButton(
                            onClick = {

                            },
                            text = "Select",
                            textStyle = MaterialTheme.typography.titleMedium,
                            padding = PaddingValues(top = 460.dp, start = 20.dp, end = 20.dp)
                        )
                    }
                }
            }

            RandomButton(
                onClick = {

                }
            )

            SkipButton(
                onClick = {
                    navController.navigate("HomeView")
                }
            )
        }
    }
}







