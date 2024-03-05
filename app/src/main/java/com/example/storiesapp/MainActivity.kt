package com.example.storiesapp


import NavManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.storiesapp.ui.theme.StoriesAppTheme
import com.example.storiesapp.viewModel.BooksViewModel
import com.example.storiesapp.viewModel.LoginViewModel
import com.example.storiesapp.viewModel.ResetViewModel
import com.example.storiesapp.viewModel.SignUpViewModel
import com.example.storiesapp.views.HomeView
import com.example.storiesapp.views.ProfileView
import com.example.storiesapp.views.login.LoginView
import com.example.storiesapp.views.signUp.SignUpView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginVM: LoginViewModel by viewModels()
        val booksVM: BooksViewModel by viewModels()
        val resetVM: ResetViewModel by viewModels()
        val signUpVM: SignUpViewModel by viewModels()

        setContent {
            val darkMode = remember{ mutableStateOf(false) }
            StoriesAppTheme(
                darkTheme = darkMode.value
            ){
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    PaymentView()
                    NavManager(booksVM, loginVM, resetVM, signUpVM)
//                    ResetView(navController)
//                    SignUpView(navController, signUpVM)
//                    LoginView(navController, loginVM)
//                    ProfileView(navController)
//                    HomeView(navController, booksVM)
//                    MainCharacterView()
                }
            }
        }
    }
}



