package com.example.firstapp.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser

class Converters {

    @TypeConverter
    fun jsonObjectToJson(value: JsonObject?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToJsonObject(value: String?): JsonObject? =
        if (JsonParser.parseString(value).isJsonObject) {
            JsonParser.parseString(value).asJsonObject
        } else JsonObject()


    @TypeConverter
    fun jsonArrayToJson(value: JsonArray?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToJsonArray(value: String?): JsonArray? =
        if (JsonParser.parseString(value).isJsonArray) {
            JsonParser.parseString(value).asJsonArray
        } else JsonArray()

}