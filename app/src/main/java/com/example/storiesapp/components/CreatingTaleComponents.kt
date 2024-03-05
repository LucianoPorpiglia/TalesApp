package com.example.storiesapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storiesapp.R

@Composable
fun PrincipalTitle(text: String){
    Text(
        text = text,
        modifier = Modifier
        .fillMaxWidth()
        .padding(top = 40.dp),
        color = MaterialTheme.colorScheme.onSecondary,
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RandomButton(
    onClick: () -> Unit
){
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 690.dp, start = 85.dp, end = 205.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(Color.Black),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = "Random",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 22.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.dice),
            contentDescription = ""
        )
    }
}