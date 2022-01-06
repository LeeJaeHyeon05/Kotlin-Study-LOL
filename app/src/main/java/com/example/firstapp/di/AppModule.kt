package com.example.firstapp.di

import android.content.Context
import androidx.room.Room
import com.example.firstapp.database.AppDatabase
import com.example.firstapp.database.dao.ChampionDao
import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.database.dao.MyBuildDao
import com.example.firstapp.database.dao.SummonerDao
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.repository.ItemRepository
import com.example.firstapp.resource.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/11
 **/

// @Provides DI(의존 주입)하는 샘플 모듈 첫번째
// 직접 대상을 리턴 하도록 구현함
// @ApplicationContext는 Hilt에 약속된어노테이션
@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    fun provideResourceProvider(@ApplicationContext context: Context): ResourceProvider {
        return ResourceProvider(context)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "lol-db").build()
    }

    @Provides
    @Singleton
    fun provideItemRepository(itemDao: ItemDao): ItemRepository {
        return ItemRepository(itemDao)
    }

    @Provides
    @Singleton
    fun provideItemDao(appDatabase: AppDatabase): ItemDao {
        return appDatabase.itemDao()
    }

    @Provides
    @Singleton
    fun provideChampionDao(appDatabase: AppDatabase): ChampionDao {
        return appDatabase.championDao()
    }

    @Provides
    @Singleton
    fun provideSummonerDao(appDatabase: AppDatabase): SummonerDao {
        return appDatabase.summonerDao()
    }

    @Provides
    @Singleton
    fun provideMyBuildRepository(myBuildDao: MyBuildDao): MyBuildRepository{
        return MyBuildRepository(myBuildDao)
    }

    @Provides
    @Singleton
    fun provideMyBuildDao(appDatabase: AppDatabase): MyBuildDao {
        return appDatabase.myBuildDao()
    }
}