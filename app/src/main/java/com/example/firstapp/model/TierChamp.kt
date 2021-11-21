package com.example.firstapp.model

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19
 **/
data class TierChamp(
    var line:Int=0,
    var championName:String="",
    var tier:String="",
    var winRate:String=""
)

data class TierLine(
    val top : ArrayList<TierChamp>,
    val mid : ArrayList<TierChamp>,
    val jungle : ArrayList<TierChamp>,
    val ads : ArrayList<TierChamp>,
    val sup : ArrayList<TierChamp>
)