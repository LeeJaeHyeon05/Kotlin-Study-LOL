package com.example.firstapp.data.api.di

import com.example.firstapp.data.api.ApiKeyInterceptor
import com.example.firstapp.data.api.SummonerApi
import com.example.firstapp.data.api.TierData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/13
 **/
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideTierData(): TierData {
        return TierData()
    }

    @Provides
    @Singleton
    @ApiOkHttpClient
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BASIC)
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideSummonerApi(@ApiOkHttpClient okHttpClient: OkHttpClient): SummonerApi {
        return Retrofit.Builder()
            .baseUrl("https://kr.api.riotgames.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(SummonerApi::class.java)
    }
}