package com.example.firstapp.data.repository

import com.example.firstapp.data.api.SummonerApi
import com.example.firstapp.model.summoner.Summoner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SummonerRepository(var summonerApi: SummonerApi) {
    suspend fun getSummoner(summonerName: String): List<Summoner> = withContext(Dispatchers.IO) {
        val summonerDto = summonerApi.getSummonerDTOBySummonerName(summonerName).body()
        when (summonerDto) {
            null -> return@withContext emptyList()
            else -> {
                return@withContext summonerApi.getSummonerByEncryptedSummonerId(summonerDto.id).body().orEmpty()
            }
        }
    }
}