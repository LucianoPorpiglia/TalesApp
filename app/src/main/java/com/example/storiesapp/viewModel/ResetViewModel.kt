package com.example.storiesapp.viewModel

import android.content.Intent
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storiesapp.repository.ResetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetViewModel @Inject constructor(private val repo: ResetRepository): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _sendEmailEnable = MutableLiveData<Boolean>()
    val sendEmailEnable: LiveData<Boolean> = _sendEmailEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onSendEmailChanged(email: String){
        _email.value = email
        _sendEmailEnable.value = isValidEmail(email)
    }

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    suspend fun onSendEmailSelected() {
        _isLoading.value = true
        val requestBody = HashMap<String, String>()
        requestBody["email"] = _email.value ?: ""
        val result = repo.reset(requestBody)
        _isLoading.value = false
        println(result)
        val intent = Intent(Intent.ACTION_SEND)
        val emailAdress = arrayOf(email)
        intent.putExtra(Intent.EXTRA_EMAIL, emailAdress)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Recover password")
        intent.putExtra(Intent.EXTRA_TEXT, "Your code here")
        intent.type = "message/rfc822"
//        context.startActivity(Intent.createChooser(intent, "Email User"))
    }
}