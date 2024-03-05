package com.example.storiesapp.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.storiesapp.R
import com.example.storiesapp.model.BooksModel

@Composable
fun CardBook(book: BooksModel, onClick: () -> Unit) {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .clickable {
                onClick()
            }
            .width(200.dp)
            .height(283.dp)
    ) {

        Box{
            MainImage(imageUrl = book.fullMediaPath())

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = book.title,
                    fontWeight = FontWeight.W600,
                    color = Color.White,
                    modifier = Modifier
                        .padding(),
                    fontFamily = FontFamily(Font(R.font.sf_pro_black)),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = book.creatorName,
                    fontWeight = FontWeight.W300,
                    color = Color.White,
                    modifier = Modifier
                        .padding(),
                    fontFamily = FontFamily(Font(R.font.sf_pro_display)),
                    maxLines = 1,
                )
            }
        }
    }
}

@Composable
fun MainImage(imageUrl: String) {
    val painter = rememberAsyncImagePainter(model = imageUrl)

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PickerView() {

    val list = listOf("Latest Releases", "My Tales", "Most Liked Tales", "Liked By Me")
    val expanded = remember { mutableStateOf(false) }
    val currentValue = remember { mutableStateOf(list[0]) }

    Column {

        Box(
            modifier = Modifier
                .height(150.dp)
                .width(200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFF891D),
                            Color(0xFFFF3939)
                        )
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        expanded.value = !expanded.value
                    }
            ) {
                Text(
                    text = currentValue.value,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 90.dp)
            ) {
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = {
                        expanded.value = false
                    }) {
                    list.forEach {
                        DropdownMenuItem(text = { Text(text = it) }, onClick = {
                            currentValue.value = it
                            expanded.value = false
                        }
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun LoginButton(
    loginEnable: Boolean,
    onLoginSelected: () -> Unit,
    padding: PaddingValues,
) {
    Button(
        onClick = {
            onLoginSelected()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .height(44.dp),
        colors = buttonColors(MaterialTheme.colorScheme.onSecondary),
        shape = RoundedCornerShape(4.dp),
        enabled = loginEnable
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SignUpButton(
    signUpEnable: Boolean,
    onSignUpSelected: () -> Unit,
    padding: PaddingValues,
) {
    Button(
        onClick = {
            onSignUpSelected()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .height(44.dp),
        colors = buttonColors(MaterialTheme.colorScheme.onSecondary),
        shape = RoundedCornerShape(4.dp),
        enabled = signUpEnable
    ) {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SendEmailButton(
    sendEmailEnable: Boolean,
    onSendEmailSelected: () -> Unit,
    padding: PaddingValues
) {
    Button(
        onClick = {
            onSendEmailSelected()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .height(44.dp),
        colors = buttonColors(MaterialTheme.colorScheme.onSecondary),
        shape = RoundedCornerShape(4.dp),
        enabled = sendEmailEnable
    ) {
        Text(
            text = "Send Email",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun PopBackButton(
    navController: NavController,
    tint: Color
) {
    IconButton(
        modifier = Modifier
            .padding(8.dp),
        onClick = {
            navController.popBackStack()
        },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "",
            modifier = Modifier
                .size(30.dp),
            tint = tint
        )
    }
}

@Composable
fun MainLogo(
    padding: PaddingValues,
    size: Dp
) {
    Image(
        painterResource(id = R.drawable.logo),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .size(size)
    )
}

@Composable
fun MainText(
    text: String,
    padding: PaddingValues
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        color = MaterialTheme.colorScheme.onSecondary,
        style = MaterialTheme.typography.titleLarge,
    )
}

@Composable
fun MiddleText(
    text: String,
    padding: PaddingValues
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        style = MaterialTheme.typography.titleSmall,
    )
}

@Composable
fun TextClickable(
    navController: NavController,
    navigator: String,
    text: String,
    padding: PaddingValues
) {
    ClickableText(
        text = AnnotatedString(text),
        onClick = {
            navController.navigate(navigator)
        },
        modifier = Modifier
            .padding(padding),
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
fun OrangeButton(
    padding: PaddingValues,
    width: Dp,
    height: Dp,
    text: String,
    onClick: () -> Unit
    ){
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .padding(padding)
            .width(width)
            .height(height)
            .background(
                color =MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp,
        )
    }
}

@Composable
fun DividerLine(
    color: Color = Color.Gray,
    padding: PaddingValues
){
    Divider(
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
    )
}

@Composable
fun ClickText(
    text: String,
    onClick: () -> Unit,
    padding: PaddingValues,
    color: Color = Color.Gray

){
    ClickableText(
        text = AnnotatedString(text),
        onClick = {
            onClick()
        },
        modifier = Modifier
            .padding(padding)
            .width(150.dp)
            .height(25.dp),
        style = MaterialTheme.typography.bodyMedium.copy(color)
    )
}

@Composable
fun StarIcon(
    isFilled: Boolean,
    onClick: () -> Unit
){
    Icon(
        painter = painterResource(if (isFilled) R.drawable.star else R.drawable.emptystar),
        contentDescription = "",
        tint = Color(0xFFE0AF00),
        modifier = Modifier.size(40.dp)
            .clickable {
                onClick()
            }
    )
}








