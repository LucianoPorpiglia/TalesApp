package com.example.storiesapp.views.login

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storiesapp.components.EmailField
import com.example.storiesapp.components.LoginButton
import com.example.storiesapp.components.MainLogo
import com.example.storiesapp.components.MainText
import com.example.storiesapp.components.MiddleText
import com.example.storiesapp.components.PasswordField
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.components.TextClickable
import com.example.storiesapp.viewModel.LoginViewModel
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
fun LoginView(navController: NavController, viewModel: LoginViewModel) {

    val email: String by viewModel.email.observeAsState("")
    val password: String by viewModel.password.observeAsState("")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    val isLoginSuccess: Boolean by viewModel.isLoginSuccess.observeAsState(false)
    val coroutineScope = rememberCoroutineScope()

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
                    text = "Let's \n" + "Get Started",
                    padding = PaddingValues(start = 35.dp, top = 320.dp)
                )

                EmailField(
                    (email),
                    { viewModel.onLoginChanged(it, password) },
                    padding = PaddingValues(start = 35.dp, end = 35.dp, top = 420.dp)
                )

                PasswordField(
                    (password),
                    { viewModel.onLoginChanged(email, it) },
                    padding = PaddingValues(start = 35.dp, end = 35.dp, top = 490.dp),
                    text = "Password"
                )

                LoginButton(
                    (loginEnable),
                    { coroutineScope.launch {
                        viewModel.onLoginSelected()
                        if (isLoginSuccess)
                        navController.navigate("HomeView")
                    } },
                    padding = PaddingValues(start = 35.dp, end = 35.dp, top = 575.dp),
                )

                MiddleText(
                    text = "Don't have an account yet?",
                    padding = PaddingValues(start = 70.dp, top = 625.dp)
                )

                TextClickable(
                    navController,
                    navigator = "SignUpView",
                    text = "Register Now",
                    padding = PaddingValues(start = 256.dp, top = 625.dp)
                )

                TextClickable(
                    navController = navController,
                    navigator = "ResetView",
                    text = "Forgot Password?",
                    padding = PaddingValues(start = 146.dp, top = 645.dp)
                )
            }
        }
}


