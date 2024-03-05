package com.example.storiesapp.data

import com.example.storiesapp.model.UserModel
import com.example.storiesapp.util.LoginConstants.Companion.BASE_URL
import com.example.storiesapp.util.LoginConstants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiAuth {

    @POST(BASE_URL + ENDPOINT)
    suspend fun login(@Body requestBody: Map<String, String>): Response<UserModel>

}