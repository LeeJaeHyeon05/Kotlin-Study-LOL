package com.example.firstapp.feature.champion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ChampionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ChampionActivity::class.java))
        }
    }

}