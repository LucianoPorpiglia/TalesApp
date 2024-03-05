package com.example.storiesapp.util

import com.example.storiesapp.TalesApplication

object TalesPreferences: Preferences(TalesApplication.instance, "TalesApp") {


    private val KEY_TOKEN = "KEY_TOKEN"
    private val KEY_EMAIL = "KEY_EMAIL"

    fun setToken(token:String?){
        set(KEY_TOKEN, token)
    }

    fun getToken(): String?{
        return get(KEY_TOKEN)
    }

    fun setEmail(user:String?){
        set(KEY_EMAIL, user)
    }

    fun getUser(): String?{
        return get(KEY_EMAIL)
    }
}