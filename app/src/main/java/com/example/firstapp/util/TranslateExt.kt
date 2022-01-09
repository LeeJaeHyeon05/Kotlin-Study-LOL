package com.example.firstapp.util

import android.content.Context
import androidx.room.Room
import com.example.firstapp.database.AppDatabase
import kotlinx.coroutines.*


/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/

// 영문 챔피언명을 한글로 바꾸기
suspend fun translateToKr(database: AppDatabase, englishName:String):String?{
    // 코루틴 결과를 반환하기 위해 Deferred를 사용하여 코루틴 생성
    var deffered : Deferred<String>
    coroutineScope {
        deffered = async(Dispatchers.IO) {
            val championName_kr = database.championDao().getChampKrName(englishName)
            return@async championName_kr
        }
    }
    return deffered.await()
}

// 한글 챔피언명을 영문으로 바꾸기
suspend fun translateToEn(database: AppDatabase, koreanName:String):String?{
    var deffered : Deferred<String>
    coroutineScope {
        deffered = async(Dispatchers.IO) {
            val championName_en = database.championDao().getChampEnName(koreanName)
            return@async championName_en
        }
    }
    return deffered.await()
}