package com.example.firstapp.feature.champion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/08
 **/
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