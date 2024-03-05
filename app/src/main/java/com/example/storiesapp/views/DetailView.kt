package com.example.storiesapp.views

import android.annotation.SuppressLint
import android.content.Intent
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.DetailTopBar
import com.example.storiesapp.components.MainImage
import com.example.storiesapp.viewModel.BooksViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(
    viewModel: BooksViewModel,
    navController: NavController,
    id: String,
) {

    val isLiked = remember{ mutableStateOf(false) }
    val darkMode = remember{ mutableStateOf(false) }
    var fontSwitch by remember{ mutableIntStateOf(1) }

    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, viewModel.state.title)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getBookById(id)
    }
    Scaffold(
        topBar = {
                DetailTopBar(
                    onClickBackButton = {
                        navController.navigate("HomeView")
                    },
                    onIncreaseFontSizeClick = {
                        if (fontSwitch < 4) {
                            fontSwitch += 1
                        } else {
                            fontSwitch = 1
                        }
                    },
                    onDarkToggle = {
                        darkMode.value = !darkMode.value
                    },
                    onShareClick = {
                        context.startActivity(shareIntent)
                    },
                    onTextToSpeech = {
                        viewModel.textToSpeech(context)
                    },
                    navController = navController
                )
        }
    ) {
        LazyColumn(
            modifier = Modifier
            .background(if (darkMode.value) MaterialTheme.colorScheme.onBackground else Color.White)) {

            item{
                Text(
                    text = viewModel.state.title.uppercase(),
                    fontFamily = FontFamily(Font(R.font.sf_pro_display3, FontWeight.W700)),
                    fontSize = 32.sp,
                    lineHeight = 32.sp,
                    letterSpacing = 0.sp,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(16.dp, top = 70.dp )

                )
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    MainImage(imageUrl = viewModel.state.mediaPath)
                }
            }
            
            item {
                Icon(painterResource(
                    id = R.drawable.like),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .offset(x = 375.dp)
                        .clip(CircleShape)
                        .clickable {
                            isLiked.value = !isLiked.value
                        },
                    tint = if (darkMode.value) {
                        if (isLiked.value) Color.Red else MaterialTheme.colorScheme.onPrimary
                    } else {
                        if (isLiked.value) Color.Red else MaterialTheme.colorScheme.onSecondary
                    }
                )
            }

            item {
                Text(
                    text = viewModel.state.content,
                    fontFamily = FontFamily(Font(R.font.eb_garamond, FontWeight.W400)),
                    fontSize = when (fontSwitch) {
                        1 -> 26.sp
                        2 -> 32.sp
                        3 -> 35.sp
                        4 -> 38.sp
                        else -> 26.sp
                    },
                    letterSpacing = 0.sp,
                    lineHeight = when (fontSwitch) {
                        1 -> 22.sp
                        2 -> 28.sp
                        3 -> 32.sp
                        4 -> 36.sp
                        else -> 22.sp
                    },
                    textAlign = TextAlign.Justify,
                    color = if (darkMode.value) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}




