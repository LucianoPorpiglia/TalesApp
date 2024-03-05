package com.example.storiesapp.views.onBoardViews


import BlurBox
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.PopBackButton

@SuppressLint("SuspiciousIndentation")
@Composable
fun LetsGetStartedView(navController: NavController){

    Column{

        Box(modifier = Modifier.fillMaxWidth()) {

            PopBackButton(navController, tint = Color.White)

            Image(
                painter = painterResource(id = R.drawable.background2),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            BlurBox(
                titleText = "Embark on an\nEpic Journey",
                descText = "Step into a world where every choice\nwrites your tale."
            )

            ButtonNext(
                onClick = {
                    navController.navigate("CreateAdventureView")
                }
            )
        }
    }
}

@Composable
fun ButtonNext(
    onClick: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onClick()
            },
            modifier = Modifier
                .padding(top = 700.dp)
                .width(137.dp)
                .height(44.dp),
            colors = buttonColors(Color.Black),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

//Button(
//onClick = {
//    onClick()
//},
//modifier = Modifier
//.fillMaxWidth()
//.padding(padding),
//shape = RoundedCornerShape(20.dp),
//colors = ButtonDefaults.buttonColors(Color(0x40000000))
//) {
//    Text(
//        text = text,
//        style = textStyle,
//        fontSize = 20.sp,
//    )
//}
