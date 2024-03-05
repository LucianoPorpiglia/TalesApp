package com.example.storiesapp.repository

import android.util.Log
import com.example.storiesapp.data.ApiBooks
import com.example.storiesapp.model.BooksModel
import retrofit2.Response
import javax.inject.Inject


class BooksRepository @Inject constructor(private val apiBooks: ApiBooks) {

    suspend fun getBooks(): List<BooksModel>? {
        val response = apiBooks.getBooks()
        if (response.isSuccessful) {
            return response.body()?.books
        }
        return null
    }

    suspend fun getBookById(id: String): BooksModel? {
        val response = apiBooks.getBookById(id)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }

}




