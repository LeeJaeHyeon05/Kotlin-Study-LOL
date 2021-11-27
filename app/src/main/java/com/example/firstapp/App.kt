package com.example.firstapp

import android.app.Application
import com.example.firstapp.data.repository.TierRepository
import com.example.firstapp.data.repository.di.RepositoryModule
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.tier.TierChamp
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/11
 **/
@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var tierRepository : TierRepository
    override fun onCreate() {
        tierRepository
        super.onCreate()
    }
}