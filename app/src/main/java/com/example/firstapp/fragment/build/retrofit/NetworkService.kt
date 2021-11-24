package com.example.firstapp.fragment.build.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import java.util.*

interface NetworkService {
    //http://ddragon.leagueoflegends.com/cdn/11.23.1/data/ko_KR/champion.json
    @GET("/cdn/11.23.1/data/ko_KR/champion.json")
    fun getChampionList() : Call<championData>
}

data class championData(
    val type: String,
    val foramt : String,
    val version: String,
    val data : Objects
)

data class championData_indiv(
    val version: String,
    val id: String,
    val key: Int,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Object,
    val image: Object,
    val tags: Object,
    val partype: String,
    val stats : Object
)