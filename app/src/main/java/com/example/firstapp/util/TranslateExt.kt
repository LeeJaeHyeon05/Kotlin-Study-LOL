package com.example.firstapp.util

import com.example.firstapp.data.db.dao.ChampionDao
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope


/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/

// 영문 챔피언명을 한글로 바꾸기
suspend fun translateToKr(championDao: ChampionDao, englishName:String):String?{
    // 코루틴 결과를 반환하기 위해 Deferred를 사용하여 코루틴 생성
    var deffered : Deferred<String>
    coroutineScope {
        deffered = async(Dispatchers.IO) {
            val championName_kr = championDao.getChampKrName(englishName)
            return@async championName_kr
        }
    }
    return deffered.await()
}

// 한글 챔피언명을 영문으로 바꾸기
suspend fun translateToEn(championDao: ChampionDao, koreanName:String):String?{
    var deffered : Deferred<String>
    coroutineScope {
        deffered = async(Dispatchers.IO) {
            val championName_en = championDao.getChampEnName(koreanName)
            return@async championName_en
        }
    }
    return deffered.await()
}