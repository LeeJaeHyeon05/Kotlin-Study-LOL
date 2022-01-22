package com.example.firstapp.di

import android.content.Context
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.data.repository.ItemRepository
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
    fun provideItemRepository(itemDao: com.example.firstapp.data.db.dao.ItemDao): ItemRepository {
        return ItemRepository(itemDao)
    }

    @Provides
    @Singleton
    fun provideMyBuildRepository(myBuildDao: com.example.firstapp.data.db.dao.MyBuildDao): MyBuildRepository{
        return MyBuildRepository(myBuildDao)
    }

}