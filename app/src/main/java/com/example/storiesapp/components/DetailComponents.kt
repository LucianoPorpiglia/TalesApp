package com.example.storiesapp.components

import android.content.Intent
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.storiesapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    onDarkToggle: () -> Unit,
    onClickBackButton: () -> Unit,
    onIncreaseFontSizeClick: () -> Unit,
    onShareClick: () -> Unit,
    onTextToSpeech: () -> Unit,
    navController: NavController
) {

    val darkMode = remember{ mutableStateOf(false) }

    TopAppBar(
        title = {
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            if (darkMode.value) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onPrimary
        ),
        actions = {
            IconButton(onClick = { onClickBackButton() }) {
                Icon(
                    painterResource(
                        id = R.drawable.back
                    ),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 6.dp),
                    tint = if (darkMode.value) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {
                    onShareClick()
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.share_ios),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = if (darkMode.value) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
                )
            }

            IconButton(
                onClick = {
                    darkMode.value = !darkMode.value
                    onDarkToggle()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.dark_mode),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = if (darkMode.value) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
                )
            }

            IconButton(
                onClick = {
                    onIncreaseFontSizeClick()
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.aa),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = if (darkMode.value) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {
                onTextToSpeech()
            }) {
                Icon(
                    painterResource(
                        id = R.drawable.playvoice
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(30.dp),
                    tint = if (darkMode.value) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary

                )
            }
        },
    )
}


