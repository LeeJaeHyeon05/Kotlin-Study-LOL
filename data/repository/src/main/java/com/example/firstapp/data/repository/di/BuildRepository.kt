package com.example.firstapp.data.repository.di

import com.example.firstapp.fragment.build.network.BuildService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * FirstApp
 * Class: BuildRepository
 * Created by 82102 on 2021-11-25.
 *
 * Description:
 */
class BuildRepository @Inject constructor(
    private val buildService: BuildService,
    private val dispatcher: CoroutineDispatcher
) {
}