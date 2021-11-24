package com.example.firstapp.data.repository

import com.example.firstapp.data.jsoup.TierData

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19
 **/
class TierRepository(private val tierData: TierData) {
    suspend fun tierData() = tierData.getTierData()
}