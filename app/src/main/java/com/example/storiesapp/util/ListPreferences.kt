package com.example.storiesapp.util

import com.example.storiesapp.TalesApplication

object ListPreferences: Preferences(TalesApplication.instance, "TalesApp") {

    private const val KEY_MEDIA_PATH = "KEY_MEDIA_PATH"

    fun setMediaPath(mediaPath:String?){
        set(KEY_MEDIA_PATH,mediaPath)
    }

    fun getMediaPath(): String?{
        return get(KEY_MEDIA_PATH)
    }
}
