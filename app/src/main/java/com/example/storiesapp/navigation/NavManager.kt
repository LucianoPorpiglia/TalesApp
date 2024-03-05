

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.storiesapp.dataStore.StoreBoarding
import com.example.storiesapp.views.onBoardViews.CreateAdventureView
import com.example.storiesapp.views.onBoardViews.LetsGetStartedView
import com.example.storiesapp.util.TalesPreferences
import com.example.storiesapp.viewModel.BooksViewModel
import com.example.storiesapp.viewModel.LoginViewModel
import com.example.storiesapp.viewModel.ResetViewModel
import com.example.storiesapp.viewModel.SignUpViewModel
import com.example.storiesapp.views.DetailView
import com.example.storiesapp.views.EditProfilePhotoView
import com.example.storiesapp.views.HomeView
import com.example.storiesapp.views.MainCharacterView
import com.example.storiesapp.views.PaymentView
import com.example.storiesapp.views.ProfileView
import com.example.storiesapp.views.SendFeedbackView
import com.example.storiesapp.views.login.LoginView
import com.example.storiesapp.views.recoverPassword.ResetView
import com.example.storiesapp.views.signUp.SignUpView

@Composable
fun NavManager(
    booksVM: BooksViewModel,
    loginVM: LoginViewModel,
    resetVM: ResetViewModel,
    signUpVM: SignUpViewModel,
){
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = true)
    val navController = rememberNavController()
    var startDestination = "LetsGetStartedView"
    val token = TalesPreferences.getToken()

    if (store.value){
        startDestination = if (!token.isNullOrEmpty()){
            "HomeView"
        }else{
            "LoginView"
        }
    }

    NavHost(navController, startDestination = startDestination){
        composable("LetsGetStartedView"){
            LetsGetStartedView(navController)
        }
        composable("CreateAdventureView"){
            CreateAdventureView(navController, dataStore)
        }
        composable("HomeView") {
            HomeView(navController, booksVM)
        }
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id"){ type = NavType.StringType }
        )){
            val id = it.arguments?.getString("id") ?: ""
            DetailView(booksVM, navController, id)
        }
        composable("ProfileView") {
            ProfileView(navController)
        }
        composable("LoginView") {
            LoginView(navController, loginVM)
        }
        composable("SignUpView") {
            SignUpView(navController, signUpVM)
        }
        composable("ResetView") {
            ResetView(navController, resetVM)
        }
        composable("PaymentView") {
            PaymentView(navController)
        }
        composable("SendFeedbackView") {
            SendFeedbackView(navController)
        }
        composable("EditProfilePhotoView") {
            EditProfilePhotoView(navController)
        }
        composable("MainCharacterView") {
            MainCharacterView(navController)
        }
    }
}