package com.example.storiesapp.model

import androidx.compose.runtime.Composable
import com.example.storiesapp.util.Constants.Companion.BASE_URL
import com.example.storiesapp.util.Constants.Companion.DOMAIN

data class BooksModel(
    val id: String,
    val likedByMe: Boolean,
    val title: String,
    val content: String,
    val mediaPath: String,
    val mediaDescription: String,
    val creator: String,
    val creatorName: String,
    val highlight: Boolean,
    val elements: List<String>,
    val language: String,
    val likes: Int
){
    fun fullMediaPath(): String{
        return DOMAIN + "images/large" + mediaPath
    }
}

//https://magictalesapp.com/images/small/elements/image-1703464501496.jpeg

