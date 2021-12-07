package com.example.firstapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.firstapp.R
import com.example.firstapp.database.dao.ChampionDao
import com.example.firstapp.eventbus.EventBus
import com.example.firstapp.eventbus.InitDataEvent
import com.example.firstapp.model.Champion
import com.example.firstapp.model.ChampionAll
import com.example.firstapp.util.getBaseImageUrl
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class InitChampionWorker @AssistedInject constructor(
        @Assisted appContext: Context,
        @Assisted workerParams: WorkerParameters,
        private val championDao: ChampionDao,
) : CoroutineWorker(appContext, workerParams) {

    private var cachedChampionCount: Int = 0

    override suspend fun doWork(): Result {
        EventBus.post(InitDataEvent(20, applicationContext.getString(R.string.init_champion_start)))

        val championCount = championDao.selectAllCount()
        Timber.i("championCount : %d", championCount)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "champion.json")
        val championAll = Gson().fromJson(jsonFileString, ChampionAll::class.java)
        val champions: Map<String, Champion> = championAll.champions

        val championList = champions.map { it.value }
        if (championCount === 0) championDao.insertAll(championList)

        championList.forEach { champion ->
            Picasso.get().load("${getBaseImageUrl()}/champion/${champion.image.get("full").asString}").fetch(object : Callback {
                override fun onSuccess() {
                    cachedChampionCount++
                }

                override fun onError(e: Exception?) {
                    cachedChampionCount++
                }
            })
        }

        while (championList.size > cachedChampionCount) {
            Thread.sleep(100)
        }

        return Result.success()
    }
}