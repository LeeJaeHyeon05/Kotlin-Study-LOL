package com.example.firstapp.data.repository

import com.example.firstapp.data.jsoup.TierData
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.tier.TierChamp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19
 **/

// tierData를 가져오게 한다
class TierRepository (private val tierData: TierData) {
    suspend fun execute() = tierData.getTierData()
}