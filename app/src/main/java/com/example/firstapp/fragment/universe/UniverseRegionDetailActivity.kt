package com.example.firstapp.fragment.universe

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityBuildDetailBinding
import com.example.firstapp.databinding.ActivityUniverseRegionDetailBinding

class UniverseRegionDetailActivity: AppCompatActivity() {

    val binding by lazy { ActivityUniverseRegionDetailBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }
}