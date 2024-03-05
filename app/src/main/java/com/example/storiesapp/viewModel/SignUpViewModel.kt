package com.example.storiesapp.viewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storiesapp.repository.SignUpRepository
import com.example.storiesapp.util.TalesPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repo: SignUpRepository): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _repeatPassword = MutableLiveData<String>()
    val repeatPassword: LiveData<String> = _repeatPassword

    private val _signUpEnable = MutableLiveData<Boolean>()
    val signUpEnable: LiveData<Boolean> = _signUpEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isSignUpSuccess = MutableLiveData<Boolean>()
    val isSignUpSuccess: LiveData<Boolean> = _isSignUpSuccess

    fun onSignUpChanged(email: String, password: String, repeatPassword: String){
        _email.value = email
        _password.value = password
        _repeatPassword.value = repeatPassword
        _signUpEnable.value = isValidEmail(email) && isValidPassword(password) == isValidPassword2(repeatPassword)
    }

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length >= 6
    private fun isValidPassword2(repeatPassword: String): Boolean = repeatPassword.length >= 6

    suspend fun onSignUpSelected() {
        if (_password.value != _repeatPassword.value){
            return
        }
        _isLoading.value = true
        val requestBody = HashMap<String, String>()
        requestBody["email"] = _email.value ?: ""
        requestBody["password"] = _password.value ?: ""
        val result = repo.signUp(requestBody)
        if (result != null ) {
            _isLoading.value = false
            TalesPreferences.setToken(result.token)
            _isSignUpSuccess.value = true
        }else{
            _isLoading.value = false
        }
    }
}