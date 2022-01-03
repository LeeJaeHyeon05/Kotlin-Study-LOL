package com.example.firstapp.data.api

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.tier.TierChamp
import com.example.firstapp.model.tier.TierLine
import org.jsoup.Jsoup
import kotlin.coroutines.coroutineContext

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19

1. TierData.kt에서 Jsoup을 사용하여 Tier 데이터를 받아온다
- 받아온 데이터는 ApiResponse<TIerLine> 형태로 반환

2. TierRepository.kt에서 1번의 TierData.kt를 실행하고 그 반환 값을 받는 execute() 메서드가 있다

3. RepositoryModule.kt에서 @Provides로 2번의 결과를 받는다
- Hilt 사용하여 DI 적용

4. TierViewModel.kt에서 @Inject를 사용하여 최종적으로 데이터를 받고 이를 line별로 분류하여 각각의 liveData에 넣는다

5. EachLineTierFragment.kt에서 position(line을 의미)별로 각기 다른 adapter에 해당 데이터를 넣고 differ를 사용하여 반영한다

 **/
class TierData {
    suspend fun getTierData(context:Context): ApiResponse<TierLine>? {
        val topTierList = ArrayList<TierChamp>()
        val midTierList = ArrayList<TierChamp>()
        val jungleTierList = ArrayList<TierChamp>()
        val adcTierList = ArrayList<TierChamp>()
        val supTierList = ArrayList<TierChamp>()

        val sharedPreferences = context.getSharedPreferences("lolVersion", Context.MODE_PRIVATE)

        // 해당 URL의 정보 가져오기
        try {
            val webDoc = Jsoup.connect("https://poro.gg/champions?format=stats").get()

            // 현재 사이트에서 제공하는 게임 버전 가져오기
            val tierVersionText =
                webDoc.select("#wrapper > div > div > div > div.container.px-0.mt-3 > div > div.col-lg-8 > div")
                    .text()
            // todo 로컬 데이터랑 버전 확인 작업 해야함 - 해당 로컬 데이터는 sharedPreference로 설정
            val gameVersion = sharedPreferences.getInt("version", 0)

            // 해당 문자열에서 숫자만 남기고 전부 삭제
            val tierVersion = tierVersionText.replace("[^0-9]".toRegex(), "").toInt()

            // todo 지금은 sharedPreference를 저장하는 기능이 없기 때문에 이 부분은 없다고 생각하는게 좋다
            if (gameVersion == tierVersion){
                ApiResponse.Success(null)
            }

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