package com.example.firstapp.model.match

import com.google.gson.JsonArray

data class MetadataDto (
    var dataVersion: String,
    var matchId: String,
    var participants: List<String>,
)

data class InfoDto (
    var gameCreation: String,
    var gameDuration: String,
    var gameEndTimestamp: String,
    var gameId: String,
    var gameMode: String,
    var gameName: String,
    var gameStartTimestamp: String,
    var gameType: String,
    var gameVersion: String,
    var mapId: String,
    var participants: JsonArray,
    var platformId: String,
    var queueId: String,
    var teams: JsonArray,
    var tournamentCode: String,
)

data class MatchDto (
    var metadata: MetadataDto,
    var info: InfoDto
)