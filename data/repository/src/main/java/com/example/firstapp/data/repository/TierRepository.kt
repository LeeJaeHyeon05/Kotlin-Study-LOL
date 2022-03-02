package com.example.firstapp.data.repository

import android.content.Context
import com.example.firstapp.data.api.TierData

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19
 **/

// tierData를 가져오게 한다
class TierRepository (private val tierData: TierData, private val context: Context) {
    suspend fun execute() = tierData.getTierData(context)
}