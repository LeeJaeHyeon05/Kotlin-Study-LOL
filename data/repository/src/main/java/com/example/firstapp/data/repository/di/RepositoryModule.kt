package com.example.firstapp.data.repository.di

import android.content.Context
import com.example.firstapp.data.api.FirstApi
import com.example.firstapp.data.repository.ChampionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideChampionRepository(
        @ApplicationContext context: Context,
    ): ChampionRepository {
        return ChampionRepository(context, FirstApi())
    }
}