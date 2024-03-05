package com.example.storiesapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.storiesapp.R

@Composable
fun TitleBar(
    padding: PaddingValues,
    text: String
){
    Text(
        modifier = Modifier
            .padding(padding),
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontSize = 32.sp
    )
}

@Composable
fun ProfileImage(
    height: Dp,
    width: Dp,
    padding: PaddingValues,
    shape: Shape,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = R.drawable.placeholder),
        contentDescription = "",
        modifier = Modifier
            .padding(padding)
            .height(height)
            .width(width)
            .clip(shape)
            .clickable {
                onClick()
            }
    )
}

@Composable
fun BlurProfileImage() {
    Image(
        painterResource(id = R.drawable.blurprofileimage),
        contentDescription = "",
        modifier = Modifier.fillMaxSize().offset(y = (-390).dp)
    )
}

@Composable
fun ActionButton(
    onClick: () -> Unit
){
    FloatingActionButton(
        onClick = {
                onClick()
            },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.clip(CircleShape).size(55.dp)
        ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            modifier = Modifier.size(30.dp)
        )

    }
}