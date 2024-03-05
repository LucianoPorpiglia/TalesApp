package com.example.storiesapp.repository

import com.example.storiesapp.data.ApiReset
import com.example.storiesapp.model.UserModel
import javax.inject.Inject

class ResetRepository @Inject constructor(private val apiReset: ApiReset) {

    suspend fun reset(requestBody: Map<String, String>): UserModel? {
        val response = apiReset.reset(requestBody)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}