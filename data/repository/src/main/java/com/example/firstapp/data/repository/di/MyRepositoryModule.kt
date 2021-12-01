package com.example.firstapp.data.repository.di

import com.example.firstapp.data.api.BuildService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

/**
 * FirstApp
 * Class: MyRepositoryModule
 * Created by 82102 on 2021-11-26.
 *
 * Description:
 */
@Module
@InstallIn(ViewModelComponent::class)
object MyRepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideBuildRepository(
        buildService: BuildService,
        dispatcher: CoroutineDispatcher
    ): BuildRepository {
        return BuildRepository(buildService, dispatcher)
    }
}