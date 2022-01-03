package com.example.firstapp.model.tier

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/19
 **/
@Entity(tableName = "championTier")
data class TierChamp(
//    var line:Int=0,
//    var championName:String="",
//    var tier:String="",
//    var winRate:String="",
    @PrimaryKey(autoGenerate = true)
    var key : Long? = null,
    @ColumnInfo(name = "name") var championName: String = "",
    @ColumnInfo(name = "tier") var tier: String = "",
    @ColumnInfo(name = "line") var line: Int = 0,
    @ColumnInfo(name = "winRate") var winRate: String = ""
)

data class TierLine(
    var top : ArrayList<TierChamp>?,
    var mid : ArrayList<TierChamp>?,
    var jungle : ArrayList<TierChamp>?,
    var adc : ArrayList<TierChamp>?,
    var sup : ArrayList<TierChamp>?
)