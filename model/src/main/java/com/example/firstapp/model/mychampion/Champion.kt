package com.example.firstapp.model.mychampion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * FirstApp
 * Class: Champion
 * Created by 82102 on 2021-11-25.
 *
 * Description:
 */
@Parcelize
data class Champion (
    val data: Map<String, Datum>
) : Parcelable



