package com.example.storiesapp.data

import com.example.storiesapp.model.BooksListResponse
import com.example.storiesapp.model.BooksModel
import com.example.storiesapp.util.Constants.Companion.BASE_URL
import com.example.storiesapp.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiBooks {

        @GET(ENDPOINT)
        suspend fun getBooks(): Response<BooksListResponse>

        @GET("$ENDPOINT/{id}")
        suspend fun getBookById(@Path(value = "id") id: String): Response<BooksModel>

}