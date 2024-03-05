package com.example.storiesapp.views.signUp

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.storiesapp.components.EmailField
import com.example.storiesapp.components.MainLogo
import com.example.storiesapp.components.MainText
import com.example.storiesapp.components.MiddleText
import com.example.storiesapp.components.PasswordField
import com.example.storiesapp.components.PopBackButton
import com.example.storiesapp.components.SignUpButton
import com.example.storiesapp.viewModel.SignUpViewModel
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
fun SignUpView(navController: NavController, viewModel: SignUpViewModel) {

    val email: String by viewModel.email.observeAsState("")
    val password: String by viewModel.password.observeAsState("")
    val repeatPassword: String by viewModel.repeatPassword.observeAsState("")
    val signUpEnable: Boolean by viewModel.signUpEnable.observeAsState(false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    val isSignUpSuccess: Boolean by viewModel.isSignUpSuccess.observeAsState(false)
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
                text = "Create \n" + "Account",
                padding = PaddingValues(start = 35.dp, top = 320.dp)
            )

            MiddleText(
                text = "Sign up now and start crafting your \n" +
                    "extraordinary tales!",
                padding = PaddingValues(start = 35.dp, top = 405.dp)
            )

            EmailField(
                email,
                { viewModel.onSignUpChanged(it, password, repeatPassword) },
                padding = PaddingValues(start = 35.dp, end = 35.dp, top = 460.dp)
            )

            PasswordField(
                password,
                { viewModel.onSignUpChanged(email, it, repeatPassword) },
                padding = PaddingValues(start = 35.dp, end = 35.dp, top = 530.dp),
                text = "Password"
            )

            PasswordField(
                repeatPassword,
                { viewModel.onSignUpChanged(email, password, it) },
                padding = PaddingValues(start = 35.dp, end = 35.dp, top = 600.dp),
                text = "Repeat Password"
            )

            SignUpButton(
                (signUpEnable),
                { coroutineScope.launch {
                    viewModel.onSignUpSelected()
                    if (isSignUpSuccess)
                        navController.navigate("HomeView")
                } },
                padding = PaddingValues(start = 35.dp, end = 35.dp, top = 680.dp))

        }
    }
}
