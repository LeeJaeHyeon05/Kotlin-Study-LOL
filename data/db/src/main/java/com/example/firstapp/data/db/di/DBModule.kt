package com.example.firstapp.data.db.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DBModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): com.example.firstapp.data.db.AppDatabase {
        return Room.databaseBuilder(context, com.example.firstapp.data.db.AppDatabase::class.java, "lol-db").build()
    }

    @Provides
    @Singleton
    fun provideItemDao(appDatabase: com.example.firstapp.data.db.AppDatabase): com.example.firstapp.data.db.dao.ItemDao {
        return appDatabase.itemDao()
    }

    @Provides
    @Singleton
    fun provideChampionDao(appDatabase: com.example.firstapp.data.db.AppDatabase): com.example.firstapp.data.db.dao.ChampionDao {
        return appDatabase.championDao()
    }

    @Provides
    @Singleton
    fun provideSummonerDao(appDatabase: com.example.firstapp.data.db.AppDatabase): com.example.firstapp.data.db.dao.SummonerDao {
        return appDatabase.summonerDao()
    }

    @Provides
    @Singleton
    fun provideMyBuildDao(appDatabase: com.example.firstapp.data.db.AppDatabase): com.example.firstapp.data.db.dao.MyBuildDao {
        return appDatabase.myBuildDao()
    }

    @Provides
    @Singleton
    fun provideChampionTierDao(appDatabase: com.example.firstapp.data.db.AppDatabase): com.example.firstapp.data.db.dao.ChampionTierDao {
        return appDatabase.championTierDao()
    }
}