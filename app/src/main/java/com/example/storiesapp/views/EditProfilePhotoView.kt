package com.example.storiesapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.CharacterItem
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.components.TransparentButton
import com.example.storiesapp.components.imagesArray

@Composable
fun EditProfilePhotoView(navController: NavController) {

    var selectedImage by remember { mutableIntStateOf(0) }
    val characters = imagesArray()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        PopBackButton(navController, tint = Color.Black)

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            items(characters) {character ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .size(height = 650.dp, width = 350.dp)
                        .border(3.dp, Color.Red, shape = RoundedCornerShape(10.dp))
                ) {

                    CharacterItem(character)

                    TransparentButton(
                        onClick = {
                            selectedImage = character
                        },
                        text = "Select",
                        textStyle = MaterialTheme.typography.titleMedium,
                        padding = PaddingValues(top = 565.dp, start = 20.dp, end = 20.dp)
                    )
                }
            }
        }
    }
}

