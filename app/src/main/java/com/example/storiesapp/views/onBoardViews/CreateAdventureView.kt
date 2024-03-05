package com.example.storiesapp.views.onBoardViews


import BlurBox
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.dataStore.StoreBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
fun CreateAdventureView(
    navController: NavController, store: StoreBoarding
) {

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        PopBackButton(navController, tint = Color.White)

        Image(
            painter = painterResource(id = R.drawable.background1),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        BlurBox(
            titleText = "Design\nMagical Worlds",
            descText = "Read others exciting adventures and\ncreate your own tales"
        )
        ButtonNext(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    store.saveBoarding(true)
                }
                navController.navigate("LoginView") {
                    popUpTo(0)
                }
            }
        )
    }
}
