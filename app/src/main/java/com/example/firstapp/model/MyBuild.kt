package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonArray

@Entity(tableName = "mybuild")
data class MyBuild(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id") var id: Int,
    @ColumnInfo (name = "champion") var champion: String,
    @ColumnInfo (name = "name") var name: String,
    @ColumnInfo (name = "skillTree") var skillTree: JsonArray?,
    @ColumnInfo (name = "notes") var notes: String,
)