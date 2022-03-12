package com.example.firstapp.data.repository

import com.example.firstapp.data.api.SummonerApi
import com.example.firstapp.model.summoner.LeagueEntryDTO
import com.example.firstapp.model.summoner.SummonerDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SummonerRepository(var summonerApi: SummonerApi) {

    suspend fun getSummonerDTOBySummonerName(summonerName: String): SummonerDTO? = withContext(Dispatchers.IO) {
        return@withContext summonerApi.getSummonerDTOBySummonerName(summonerName).let { response ->
            if (response.isSuccessful) response.body()
            else null
        }
    }

    private suspend fun getSummonerByEncryptedSummonerId(summonerDTO: SummonerDTO?): List<LeagueEntryDTO> = withContext(Dispatchers.IO) {
        return@withContext summonerDTO?.id?.let { id ->
            summonerApi.getSummonerByEncryptedSummonerId(id).let { response ->
                if (response.isSuccessful) response.body()
                else emptyList()
            }
        }.orEmpty()
    }

    suspend fun getSummoner(summonerName: String): List<LeagueEntryDTO> = withContext(Dispatchers.IO) {
        return@withContext getSummonerByEncryptedSummonerId(getSummonerDTOBySummonerName(summonerName))
    }

}