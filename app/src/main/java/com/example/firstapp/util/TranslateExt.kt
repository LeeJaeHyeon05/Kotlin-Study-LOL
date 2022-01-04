package com.example.firstapp.util

import com.example.firstapp.model.champion.Champion
import com.example.firstapp.model.champion.ChampionVO
import java.lang.Exception

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/

// 영문 챔피언명을 한글로 바꾸기
fun ChampionVO.translateToKr(EnglishName:String):String?{
    // 챔피언 HashMap에서 key(챔피언 영문 이름)를 사용하여 한글로된 이름을 가져온다
    if (data[EnglishName]!=null){
        try{
            return data[EnglishName]!!.name
        }
        // 실패하거나 해당 이름이 없는 경우 그냥 영문명을 반환
        catch (e:Exception){
            return EnglishName
        }
    }else return null
}

// 한글 챔피언명을 영문으로 바꾸기
fun ChampionVO.translateToEn(KoreanName:String):String?{
    // data의 모든 Champion 데이터를 비교합니다.
    for (champions in data){
        val championInfo = champions.value
        if (championInfo.name == KoreanName) {
            return championInfo.name
        }
    }
    return null
}