package com.example.firstapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.firstapp.R
import com.example.firstapp.data.repository.TierRepository
import com.example.firstapp.database.dao.ChampionTierDao
import com.example.firstapp.eventbus.EventBus
import com.example.firstapp.eventbus.InitDataEvent
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.tier.TierChamp
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class InitChampionTierWorker @AssistedInject constructor(
        @Assisted appContext: Context,
        @Assisted workerParams: WorkerParameters,
        private val tierRepository: TierRepository,
        private val championTierDao: ChampionTierDao,
) : CoroutineWorker(appContext, workerParams) {

    private var cachedSummonerCount: Int = 0
//    var topData = ArrayList<TierChamp>()
//    var jungleData = ArrayList<TierChamp>()
//    var midData = ArrayList<TierChamp>()
//    var adcData = ArrayList<TierChamp>()
//    var supData = ArrayList<TierChamp>()
    var tierData = ArrayList<TierChamp>()

    override suspend fun doWork(): Result {
        EventBus.post(InitDataEvent(80, applicationContext.getString(R.string.init_tier_start)))

        val championTierCount = championTierDao.selectAllCount()
        Timber.i("championTierCount : %d", championTierCount)

        // todo Jsoup으로 tierData 가져오기
        when(val response = tierRepository.execute()){
            is ApiResponse.Success ->{
                if (response != null){
                    tierData.clear()

                    tierData.addAll(response.value.top!!)
                    tierData.addAll(response.value.jungle!!)
                    tierData.addAll(response.value.mid!!)
                    tierData.addAll(response.value.adc!!)
                    tierData.addAll(response.value.sup!!)
                }
            }
            is ApiResponse.Failure -> {
                Timber.d("error: " + response.e)
            }
        }

        championTierDao.insertAll(tierData)

        EventBus.post(InitDataEvent(Integer.MAX_VALUE, applicationContext.getString(R.string.finish)))
        return Result.success()
    }
}