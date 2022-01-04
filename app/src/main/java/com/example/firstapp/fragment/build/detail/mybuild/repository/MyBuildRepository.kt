package com.example.firstapp.fragment.build.detail.mybuild.repository

class MyBuildRepository {

    companion object{
        var myBuildByChampion = hashMapOf(String to mutableListOf<DataForMyBuildRepository>())
    }

    fun insertNewDataToChampionName(data: DataForMyBuildRepository, championName: String.Companion){
        myBuildByChampion[championName]?.add(data)
    }
}

data class DataForMyBuildRepository(
    var buildName: String
    //var summonerSpells,
    //var fullBuilds
    //var Trinket
    //var customItemBuilds
    //var skillOrder
    //var rune
)
