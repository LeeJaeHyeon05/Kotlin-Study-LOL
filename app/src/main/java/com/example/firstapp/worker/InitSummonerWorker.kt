package com.example.firstapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.firstapp.R
import com.example.firstapp.database.dao.SummonerDao
import com.example.firstapp.eventbus.EventBus
import com.example.firstapp.eventbus.InitDataEvent
import com.example.firstapp.model.Summoner
import com.example.firstapp.model.SummonerAll
import com.example.firstapp.util.getBaseImageUrl
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class InitSummonerWorker @AssistedInject constructor(
        @Assisted appContext: Context,
        @Assisted workerParams: WorkerParameters,
        private val summonerDao: SummonerDao,
) : CoroutineWorker(appContext, workerParams) {

    private var cachedSummonerCount: Int = 0

    override suspend fun doWork(): Result {
        EventBus.post(InitDataEvent(60, applicationContext.getString(R.string.init_summoner_start)))

        val summonerCount = summonerDao.selectAllCount()
        Timber.i("summonerCount : %d", summonerCount)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "summoner.json")
        val summonerAll = Gson().fromJson(jsonFileString, SummonerAll::class.java)
        val summoners: Map<String, Summoner> = summonerAll.summoners

        val summonerList = summoners.map { it.value }
        if (summonerCount === 0) summonerDao.insertAll(summonerList)

        summonerList.forEach { summoner ->
            Picasso.get().load("${getBaseImageUrl()}/spell/${summoner.id}.png").fetch(object : Callback {
                override fun onSuccess() {
                    cachedSummonerCount++
                }

                override fun onError(e: Exception?) {
                    cachedSummonerCount++
                }
            })
        }

        while (summonerList.size > cachedSummonerCount) {
            Thread.sleep(100)
        }

        return Result.success()
    }

}