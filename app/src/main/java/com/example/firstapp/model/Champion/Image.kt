package com.example.firstapp.model.Champion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image (
    val full: String,
//    val sprite: Sprite,
//    val group: Type,
    val x: Long,
    val y: Long,
    val w: Long,
    val h: Long
): Parcelable