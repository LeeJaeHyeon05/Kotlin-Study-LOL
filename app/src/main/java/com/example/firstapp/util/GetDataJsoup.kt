package com.example.firstapp.util

import android.util.Log
import com.example.firstapp.model.TierChamp
import org.jsoup.Jsoup

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19
 **/
object GetDataJsoup {
    // 아래 함수는 코루틴으로 실시해야합니다.
    fun tierData(): ArrayList<TierChamp>? {
        val tierChampDataList = ArrayList<TierChamp>()

        // 해당 URL의 정보 가져오기
        try {
            val webDoc = Jsoup.connect("https://poro.gg/champions?format=stats").get()

            // 현재 사이트에서 제공하는 게임 버전 가져오기
            val tierVersionText = webDoc.select("#wrapper > div > div > div > div.container.px-0.mt-3 > div > div.col-lg-8 > div")
                .text()
            // todo 로컬 데이터랑 버전 확인 작업 해야함
            val tierVersion = tierVersionText.replace("[^0-9]".toRegex(), "")

//            val testName = webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child(5) > div:nth-child(21) > div.champion > a > div > span").text()
//            val testTier = webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child(5) > div:nth-child(21) > div:nth-child(3) > img").attr("alt").toString()
//            val testWinRate = webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child(5) > div:nth-child(21) > div:nth-child(4)").text()
//
//            Log.d("jsoup", "testName: $testName")
//            Log.d("jsoup", "testTier: $testTier")
//            Log.d("jsoup", "testWinRate: $testWinRate")

            // 각 라인별 티어 확인
            // line은 순서대로 탑, 정글, 미드, 원딜, 서폿
            tierChampDataList.clear()
            for (line in 1 until 6) {
                // 각 line에 대한 챔피언 tier 데이터 가져오기
                for (rank in 2 until 62) {
                    // 라인 선별
                    val tierChamp = TierChamp()
                    tierChamp.line = line
                    tierChamp.championName = webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child($line) > div:nth-child($rank) > div.champion > a > div > span")
                            .text()
                    tierChamp.tier = webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child($line) > div:nth-child($rank) > div:nth-child(3) > img")
                            .attr("alt").toString()
                    tierChamp.winRate = webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child($line) > div:nth-child($rank) > div:nth-child(4)")
                            .text()

                    // 라인별로 데이터 길이가 다르기 때문에 break를 해준다
                    if (tierChamp.championName == "") {
                        Log.d("jsoup", "break됨")
                        break
                    } else {
                        tierChampDataList.add(tierChamp)
                    }
                }
            }
            Log.d("jsoup", "tierDataList: $tierChampDataList")

            return tierChampDataList

        } catch (e: Exception) {
            Log.d("JSoup", "통신에러: ${e.printStackTrace()}")
            return null
        }
    }
}