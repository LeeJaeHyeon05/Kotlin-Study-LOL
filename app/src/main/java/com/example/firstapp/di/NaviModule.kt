package com.example.firstapp.di

import com.example.firstapp.navigator.AppNavigator
import com.example.firstapp.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/11
 **/
// @Provides DI(의존 주입)하는 샘플 모듈 두번째
// Interface를 사용 추상 클래스를 주입 할 때 사용
// @ApplicationContext는 Hilt에 약속된어노테이션
// 클래스를 abstract로 선언하는 것 주의
@InstallIn(ActivityComponent::class)
@Module
abstract class NaviModule {
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}