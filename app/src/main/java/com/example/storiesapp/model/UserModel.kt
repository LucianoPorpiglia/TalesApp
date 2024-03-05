package com.example.storiesapp.model

class UserModel(
    val id: String,
    val mediaPath: String,
    val email: String,
    val userName: String,
    val credits: Int,
    val isVerified: Boolean,
    val token: String,
    val refreshToken: String,
) {
}