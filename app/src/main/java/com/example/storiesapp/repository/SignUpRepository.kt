package com.example.storiesapp.repository

import com.example.storiesapp.data.ApiSignUp
import com.example.storiesapp.model.UserModel
import javax.inject.Inject

class SignUpRepository @Inject constructor(private val apiSignUp: ApiSignUp) {

    suspend fun signUp(requestBody: Map<String, String>): UserModel? {
        val response = apiSignUp.signUp(requestBody)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

}