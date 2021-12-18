package com.example.firstapp.data.api

import android.util.Log
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.tier.TierChamp
import com.example.firstapp.model.tier.TierLine
import org.jsoup.Jsoup

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19
 **/
class TierData {
    suspend fun getTierData(): ApiResponse<TierLine> {
        val topTierList = ArrayList<TierChamp>()
        val midTierList = ArrayList<TierChamp>()
        val jungleTierList = ArrayList<TierChamp>()
        val adcTierList = ArrayList<TierChamp>()
        val supTierList = ArrayList<TierChamp>()

        // 해당 URL의 정보 가져오기
        try {
            val webDoc = Jsoup.connect("https://poro.gg/champions?format=stats").get()

            // 현재 사이트에서 제공하는 게임 버전 가져오기
            val tierVersionText =
                webDoc.select("#wrapper > div > div > div > div.container.px-0.mt-3 > div > div.col-lg-8 > div")
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
            // line은 순서대로 탑, 미드, 정글, 원딜, 서폿
            val tierLine = TierLine(top = null, mid = null, jungle = null, adc = null, sup = null)
            for (line in 1 until 6) {
                // 각 line에 대한 챔피언 tier 데이터 가져오기
                for (rank in 2 until 52) {
                    // 라인 선별
                    val tierChamp = TierChamp()
                    tierChamp.let {
                        it.line = line
                        it.championName =
                            webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child($line) > div:nth-child($rank) > div.champion > a > div > span")
                                .text()
                        it.tier =
                            webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child($line) > div:nth-child($rank) > div:nth-child(3) > img")
                                .attr("alt").toString()
                        it.winRate =
                            webDoc.select("#wrapper > div > div > div > div.container.mt-3.mt-md-4.p-0 > div > div.col-lg-4 > div.champion-sub-list-wrap.champion-sub-tier-list > div.champion-sub-list > div:nth-child($line) > div:nth-child($rank) > div:nth-child(4)")
                                .text()
                    }
                    // 라인별로 데이터 길이가 다르기 때문에 break를 해준다
                    if (tierChamp.championName == "") {
                        Log.d("jsoup", "break됨($line)")
                        break
                    }
                    else {
                        // 챔피언 라인별로 저장 처리를 따로 한다
                        when(tierChamp.line){
                            1 -> topTierList.add(tierChamp)
                            2 -> jungleTierList.add(tierChamp)
                            3 -> midTierList.add(tierChamp)
                            4 -> adcTierList.add(tierChamp)
                            5 -> supTierList.add(tierChamp)
                        }
                    }
                }
            }
            tierLine.top = topTierList
            tierLine.mid = midTierList
            tierLine.jungle = jungleTierList
            tierLine.adc = adcTierList
            tierLine.sup = supTierList

            // 각 라인별 데이터 로그 출력
            Log.d("jsoup", "top: ${tierLine.top}")
            Log.d("jsoup", "mid: ${tierLine.mid}")
            Log.d("jsoup", "jungle: ${tierLine.jungle}")
            Log.d("jsoup", "adc: ${tierLine.adc}")
            Log.d("jsoup", "sup: ${tierLine.sup}")

            return ApiResponse.Success(tierLine)

        } catch (e: Exception) {
            Log.d("JSoup", "통신에러: ${e.printStackTrace()}")
            return ApiResponse.Failure(e)
        }
    }
}