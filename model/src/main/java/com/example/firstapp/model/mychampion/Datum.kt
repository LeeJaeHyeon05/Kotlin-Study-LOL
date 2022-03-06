package com.example.firstapp.model.mychampion

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize
data class Datum (
    val id: String,
    val key: String,
    val name: String,
    val tags: List<String>,
): Parcelable