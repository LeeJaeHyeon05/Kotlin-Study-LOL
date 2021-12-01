package com.example.firstapp.data.repository.di

import androidx.annotation.WorkerThread
import com.example.firstapp.data.api.BuildService
import com.example.firstapp.model.mychampion.Champion
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * FirstApp
 * Class: BuildRepository
 * Created by woosung on 2021-11-25.
 *
 * Description:
 */

class BuildRepository @Inject constructor(
    private val buildService: BuildService,
    private val dispatcher: CoroutineDispatcher
) {

    init {

    }


    @WorkerThread
    fun getChampions(
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
        onException: (String) -> Unit

    ) = flow<Champion> {

        val bulidResponse = buildService.fetchChampions()

        //Success시 이쪽으로 들어온다.
        bulidResponse.suspendOnSuccess {
            data.whatIfNotNull { response ->
                onSuccess()
                emit(response)
            }
        }
            .onError {
                onError(message())
            }
            .onException {
                onException(message())
            }

    }.flowOn(dispatcher)
}