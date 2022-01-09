package com.example.firstapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.firstapp.database.dao.ChampionDao
import com.example.firstapp.database.dao.ChampionTierDao
import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.database.dao.MyBuildDao
import com.example.firstapp.database.dao.SummonerDao
import com.example.firstapp.model.Champion
import com.example.firstapp.model.Item
import com.example.firstapp.model.MyBuild
import com.example.firstapp.model.Summoner
import com.example.firstapp.model.tier.TierChamp

@Database(entities = [Item::class, Champion::class, Summoner::class, TierChamp::class, MyBuild::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun championDao(): ChampionDao
    abstract fun summonerDao(): SummonerDao
    abstract fun myBuildDao(): MyBuildDao
    abstract fun championTierDao(): ChampionTierDao
}
