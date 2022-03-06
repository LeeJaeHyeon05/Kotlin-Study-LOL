package com.example.firstapp.data.repository

import com.example.firstapp.data.api.di.ApiModule
import com.example.firstapp.data.repository.di.RepositoryModule
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SummonerRepositoryTest {

    @Test
    fun getSummoner() = runBlocking {

        val apiModule = ApiModule()
        val repositoryModule = RepositoryModule()
        val summonerApi = apiModule.provideSummonerApi(apiModule.provideOkHttpClient())
        val summonerRepository = repositoryModule.provideSummonerRepository(summonerApi)

        val summonerList = summonerRepository.getSummoner("hideonbush")
        Assert.assertEquals("Hide on bush", summonerList[0].summonerName)
    }
}