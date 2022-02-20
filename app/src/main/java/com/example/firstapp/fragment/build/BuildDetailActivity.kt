package com.example.firstapp.fragment.build

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityBuildDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuildDetailActivity : AppCompatActivity() {

    val binding by lazy { ActivityBuildDetailBinding.inflate(layoutInflater) }
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_build_detail) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_build_detail)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

