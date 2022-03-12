package com.example.firstapp.data.repository

import com.example.firstapp.data.api.MatchApi
import com.example.firstapp.model.match.MatchDto

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatchRepository(var matchApi: MatchApi) {

    private suspend fun getMatchIds(puuid: String): List<String> = withContext(Dispatchers.IO) {
        return@withContext matchApi.getMatchIds(puuid).let { response ->
            if (response.isSuccessful) response.body()
            else emptyList()
        }.orEmpty()
    }

    private suspend fun getMatch(matchId: String): MatchDto? = withContext(Dispatchers.IO) {
        return@withContext matchApi.getMatch(matchId).let { response ->
            if (response.isSuccessful) response.body()
            else null
        }
    }

    suspend fun getMatches(puuid: String): List<MatchDto> = withContext(Dispatchers.IO) {
        return@withContext getMatchIds(puuid).mapNotNull { matchId -> getMatch(matchId) }
    }

}