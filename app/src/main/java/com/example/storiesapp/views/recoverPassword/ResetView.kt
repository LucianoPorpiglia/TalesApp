package com.example.storiesapp.views.recoverPassword

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storiesapp.components.MainLogo
import com.example.storiesapp.components.MainText
import com.example.storiesapp.components.MiddleText
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.components.ResetEmailField
import com.example.storiesapp.components.SendEmailButton
import com.example.storiesapp.viewModel.ResetViewModel
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
fun ResetView(navController: NavController, viewModel: ResetViewModel) {
    val email: String by viewModel.email.observeAsState("")
    val sendEmailEnable: Boolean by viewModel.sendEmailEnable.observeAsState(false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    if (isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Box {
            PopBackButton(
                navController,
                tint = Color.Black
            )

            MainLogo(padding = PaddingValues(top = 87.dp), size = 200.dp)

            MainText(
                text = "Recover \n" + "Password",
                padding = PaddingValues(start = 35.dp, top = 320.dp)
            )

            MiddleText(
                text = "Please insert your account details and we will\n" +
                        "send you an email with a code to reset your\n" +
                        "password.",
                padding = PaddingValues(start = 35.dp, top = 410.dp)
            )

            ResetEmailField(
                (email),
                { viewModel.onSendEmailChanged(it) },
                padding = PaddingValues(start = 35.dp, end = 35.dp, top = 490.dp)
            )

            SendEmailButton(
                (sendEmailEnable),
                { coroutineScope.launch { viewModel.onSendEmailSelected() } },
                padding = PaddingValues(start = 35.dp, end = 35.dp, top = 575.dp),
            )
        }
    }
}



