package com.example.firstapp.data.repository

import com.example.firstapp.data.api.FirstApi

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/13
 **/
class ChampionRepository(
    private val firstApi: FirstApi
) {
    suspend fun championInfo() = firstApi.getChampionInfo()
}