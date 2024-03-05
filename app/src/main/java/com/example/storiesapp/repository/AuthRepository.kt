package com.example.storiesapp.repository

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.storiesapp.data.ApiAuth
import com.example.storiesapp.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiAuth: ApiAuth) {

    suspend fun login(requestBody: Map<String, String>): UserModel? {
        val response = apiAuth.login(requestBody)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

}