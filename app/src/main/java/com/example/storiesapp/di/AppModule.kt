package com.example.storiesapp.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.storiesapp.R
import com.example.storiesapp.data.ApiAuth
import com.example.storiesapp.data.ApiBooks
import com.example.storiesapp.data.ApiReset
import com.example.storiesapp.data.ApiSignUp
import com.example.storiesapp.data.AuthorizationInterceptor
import com.example.storiesapp.util.Constants.Companion.BASE_URL
import com.example.storiesapp.util.TalesPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        val authToken = TalesPreferences.getToken()
        val interceptor = AuthorizationInterceptor(authToken ?: "")

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiBooks(retrofit: Retrofit) : ApiBooks {
        return retrofit.create(ApiBooks::class.java)
    }

    @Singleton
    @Provides
    fun providesApiAuth(retrofit: Retrofit) : ApiAuth {
        return retrofit.create(ApiAuth::class.java)
    }

    @Singleton
    @Provides
    fun providesApiReset(retrofit: Retrofit) : ApiReset {
        return retrofit.create(ApiReset::class.java)
    }

    @Singleton
    @Provides
    fun providesApiSignUp(retrofit: Retrofit) : ApiSignUp {
        return retrofit.create(ApiSignUp::class.java)
    }
}