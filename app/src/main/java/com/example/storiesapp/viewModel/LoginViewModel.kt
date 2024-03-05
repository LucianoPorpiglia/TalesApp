package com.example.storiesapp.viewModel

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.storiesapp.model.UserModel
import com.example.storiesapp.repository.AuthRepository
import com.example.storiesapp.util.TalesPreferences
import com.example.storiesapp.views.HomeView
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepository): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccess: LiveData<Boolean> = _isLoginSuccess

    fun onLoginChanged(email: String, password: String){
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean = password.length >= 6

    suspend fun onLoginSelected() {
        _isLoading.value = true
        val requestBody = HashMap<String, String>()
        requestBody["email"] = _email.value ?: ""
        requestBody["password"] = _password.value ?: ""
        val result = repo.login(requestBody)
        if (result != null ) {
            _isLoading.value = false
            println(result)
            TalesPreferences.setToken(result.token)
            _isLoginSuccess.value = true
        }else{
            _isLoading.value = false
        }
    }
}
