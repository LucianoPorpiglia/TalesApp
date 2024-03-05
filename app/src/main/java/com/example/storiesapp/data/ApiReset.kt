package com.example.storiesapp.data

import com.example.storiesapp.model.UserModel
import com.example.storiesapp.util.ResetConstants.Companion.BASE_URL
import com.example.storiesapp.util.ResetConstants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiReset {


    @GET(BASE_URL + ENDPOINT)
    suspend fun reset(@QueryMap requestBody: Map<String, String>): Response<UserModel>

}