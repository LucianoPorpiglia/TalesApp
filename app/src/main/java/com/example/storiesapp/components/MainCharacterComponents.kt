package com.example.storiesapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storiesapp.R

@Composable
fun imagesArray(): List<Int> {
    return listOf(
        R.drawable.mage,
        R.drawable.fox,
        R.drawable.wolf,
        R.drawable.war
    )
}


@Composable
fun CharacterItem(character: Int) {
    Image(
        painter = painterResource(id = character),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(10.dp))
    )
}

@Composable
fun TransparentButton(
    text: String,
    textStyle: TextStyle,
    padding: PaddingValues,
    onClick: () -> Unit,
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(Color(0x40000000))
    ) {
        Text(
            text = text,
            style = textStyle,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun SkipButton(
    onClick: () -> Unit
){
    ClickableText(
        modifier = Modifier.padding(top = 700.dp, start = 280.dp),
        text = AnnotatedString("Skip"),
        style = MaterialTheme.typography.bodyMedium,
        onClick = {
            onClick()
        }
    )
}