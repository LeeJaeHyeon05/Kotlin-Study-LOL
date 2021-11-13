package com.example.firstapp.data.repository.di

import com.example.firstapp.data.api.FirstApi
import com.example.firstapp.data.repository.ChampionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/13
 **/
@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideChampionRepository(): ChampionRepository {
        return ChampionRepository(FirstApi())
    }
}