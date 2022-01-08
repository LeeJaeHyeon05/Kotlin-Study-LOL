package com.example.firstapp.data.repository.di

import android.content.Context
import com.example.firstapp.data.api.FirstApi
import com.example.firstapp.data.api.TierData
import com.example.firstapp.data.repository.ChampionRepository
import com.example.firstapp.data.repository.TierRepository
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
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideChampionRepository(): ChampionRepository {
        return ChampionRepository(FirstApi())
    }

    @Provides
    @Singleton
    fun provideTierRepository(tierData: TierData, context: Context):TierRepository{
        return TierRepository(tierData, context)
    }
}