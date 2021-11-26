package com.example.firstapp.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listStringToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListString(value: String) = Gson().fromJson(value, Array<String>::class.java)?.toList()

}