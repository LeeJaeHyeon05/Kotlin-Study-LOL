package com.example.firstapp.fragment.build.detail.mybuild.repository

import android.content.Context
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext

class MyBuildRepository(context: Context) {

    private val myBuildPreference = context.getSharedPreferences("MyBuildPreference", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun addMyBuildData(championName: String, data: MyBuildRepositoryData){

        myBuildPreference.edit().run {
            val json = gson.toJson(data)

            var no = 1
            while(myBuildPreference.getString("${championName}$no","") != ""){
                no ++
            }

            var cn = "${championName}$no"
            putString(cn, json)
            commit()

            //<MyBuildPreference File>
            //Garen1 -> 데이터   Fizz1 -> 데이터   Khazix1 -> 데이터
            //Garen2 -> 데이터
        }
    }

    fun getMyBuildData(championName: String): MutableList<MyBuildRepositoryData> {
        val myBuildDataList = mutableListOf<MyBuildRepositoryData>()

        var no = 1
        while(myBuildPreference.getString("${championName}$no","") != ""){
            val myBuildData = myBuildPreference.getString("${championName}$no", "")
            val data = gson.fromJson(myBuildData, MyBuildRepositoryData::class.java)
            myBuildDataList.add(data)
            no ++
        }

        return myBuildDataList
    }
}

data class MyBuildRepositoryData(
    var buildName: String
    //var summonerSpells,
    //var fullBuilds
    //var Trinket
    //var customItemBuilds
    //var skillOrder
    //var rune
)
