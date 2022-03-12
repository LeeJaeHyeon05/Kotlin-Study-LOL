package com.example.firstapp.model.summoner

data class SummonerDTO (
    var accountId: String,
    var profileIconId: Int,
    var revisionDate: Long,
    var name: String,
    var id: String,
    var puuid: String,
    var summonerLevel: Long
)

data class LeagueEntryDTO (
    var leagueId: String,
    var queueType: String,
    var tier: String,
    var rank: String,
    var summonerId: String,
    var summonerName: String,
    var leaguePoints: Int,
    var wins: Int,
    var losses: Int,
    var veteran: Boolean,
    var inactive: Boolean,
    var freshBlood: Boolean,
    var hotStreak: Boolean,
)