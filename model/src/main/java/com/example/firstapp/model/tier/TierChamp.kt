package com.example.firstapp.model.tier

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
    var top : ArrayList<TierChamp>?,
    var mid : ArrayList<TierChamp>?,
    var jungle : ArrayList<TierChamp>?,
    var adc : ArrayList<TierChamp>?,
    var sup : ArrayList<TierChamp>?
)