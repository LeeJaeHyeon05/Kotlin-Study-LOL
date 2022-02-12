package com.example.firstapp.data.repository

import com.example.firstapp.data.api.di.ApiModule
import com.example.firstapp.data.repository.di.RepositoryModule
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MatchRepositoryTest {

    private lateinit var matchRepository: MatchRepository

    @Before
    fun setup() = run {
        val apiModule = ApiModule()
        val repositoryModule = RepositoryModule()
        val matchApi = apiModule.provideMatchApi(apiModule.provideOkHttpClient())
        matchRepository = repositoryModule.provideMatchRepository(matchApi)
    }

    @Test
    fun getMatches() = runBlocking {
        val puuid = "PYhPrSROCbhAAoMpIR70Wq-PDlwM-aHloPE99OxWC0iPn9q-0YEImkHntPDRe3hbhNqvkJ-TOjX6TQ"
        val matches = matchRepository.getMatches(puuid)
        Assert.assertTrue(matches.isNotEmpty())
    }
}