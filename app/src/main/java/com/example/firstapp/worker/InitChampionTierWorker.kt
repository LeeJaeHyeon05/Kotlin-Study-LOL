package com.example.firstapp.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.firstapp.R
import com.example.firstapp.data.repository.TierRepository
import com.example.firstapp.data.db.dao.ChampionTierDao
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
    private val championTierDao: com.example.firstapp.data.db.dao.ChampionTierDao,
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

        when(val response = tierRepository.execute()){
            is ApiResponse.Success ->{
                if (response.value != null){
                    tierData.clear()

                    tierData.addAll(response.value!!.top!!)
                    tierData.addAll(response.value!!.jungle!!)
                    tierData.addAll(response.value!!.mid!!)
                    tierData.addAll(response.value!!.adc!!)
                    tierData.addAll(response.value!!.sup!!)

                    // 데이터를 추가하기 전에 모든 데이터 삭제하기
                    championTierDao.clearAll()

                    championTierDao.insertAll(tierData)
                }else{
                    Log.d("TierWorker", "response가 Success이지만 그 값이 null임")
                }
            }
            is ApiResponse.Failure -> {
                Timber.d("error: " + response.e)
            }
        }

        EventBus.post(InitDataEvent(Integer.MAX_VALUE, applicationContext.getString(R.string.finish)))
        return Result.success()
    }
}