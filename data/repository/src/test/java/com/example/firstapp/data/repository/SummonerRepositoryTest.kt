package com.example.firstapp.data.repository

import com.example.firstapp.data.api.di.ApiModule
import com.example.firstapp.data.repository.di.RepositoryModule
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SummonerRepositoryTest {

    private lateinit var summonerRepository: SummonerRepository

    @Before
    fun setup() = run {
        val apiModule = ApiModule()
        val repositoryModule = RepositoryModule()
        val summonerApi = apiModule.provideSummonerApi(apiModule.provideOkHttpClient())
        summonerRepository = repositoryModule.provideSummonerRepository(summonerApi)
    }

    @Test
    fun getSummoner() = runBlocking {
        val summonerList = summonerRepository.getSummoner("hideonbush")
        Assert.assertEquals("Hide on bush", summonerList[0].summonerName)
    }

}