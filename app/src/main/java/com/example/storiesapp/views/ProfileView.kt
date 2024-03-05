package com.example.storiesapp.views

import PrimaryButton
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storiesapp.R
import com.example.storiesapp.components.BlurProfileImage
import com.example.storiesapp.components.ClickText
import com.example.storiesapp.components.DividerLine
import com.example.storiesapp.components.OrangeButton
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.components.ProfileImage

@Composable
fun ProfileView(navController: NavController) {

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {

        Box {
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
            ) {

                BlurProfileImage()

                ProfileImage(
                    onClick = {},
                    height = 200.dp,
                    width = 196.dp,
                    padding = PaddingValues(top = 30.dp),
                    shape = CircleShape
                )

                Image(painterResource(id = R.drawable.editicon),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 125.dp, top = 170.dp)
                        .size(width = 55.dp, height = 55.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate("EditProfilePhotoView")
                        }
                )



                Text(
                    text = "Luciano Porpiglia",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 240.dp)
                )
                Text(
                    text = "luciano.porpiglia@gmail.com",
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 270.dp)
                )
            }

            PopBackButton(navController, tint = Color.White)

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 105.dp)
                    .width(336.dp)
                    .height(177.dp)
                    .background(
                        color = Color(0x29FF891D), shape = RoundedCornerShape(20.dp)
                    )
            )

            Image(
                painterResource(id = R.drawable.coin),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 372.dp, start = 50.dp)
                    .size(width = 158.dp, height = 158.dp),
            )

            Text(
                text = "credits",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(top = 440.dp, start = 254.dp)
            )

            PrimaryButton(
                onClick = {
                          navController.navigate("PaymentView")
                },
                padding = PaddingValues(start = 230.dp, end = 65.dp, top = 475.dp),
                text = "Get More",
                textStyle = MaterialTheme.typography.titleSmall
            )

            ClickText(
                text = "SEND FEEDBACK",
                onClick = {
                    navController.navigate("SendFeedbackView")
                },
                padding = PaddingValues(top = 575.dp, start = 24.dp)
            )

            DividerLine(
                padding = PaddingValues(top = 605.dp, start = 20.dp, end = 20.dp)
            )

            ClickText(
                text = "ABOUT US",
                onClick = {
                    val uri = Uri.parse("https://magictalesapp.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                },
                padding = PaddingValues(top = 635.dp, start = 24.dp)
            )

            DividerLine(
                padding = PaddingValues(top = 665.dp, start = 20.dp, end = 20.dp)
            )

            ClickText(
                text = "LOG OUT",
                onClick = {

                },
                padding = PaddingValues(top = 695.dp, start = 24.dp),
                color = Color.Red
            )

            DividerLine(
                color = Color.Red,
                padding = PaddingValues(top = 725.dp, start = 20.dp, end = 20.dp)
            )
        }
    }
}