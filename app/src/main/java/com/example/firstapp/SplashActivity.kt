package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.firstapp.databinding.ActivitySplashBinding
import com.example.firstapp.eventbus.EventBus
import com.example.firstapp.eventbus.InitDataEvent
import com.example.firstapp.worker.InitChampionWorker
import com.example.firstapp.worker.InitItemWorker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun updateProgress(initDataEvent: InitDataEvent) {
        Timber.i("initDataEvent : %d %s", initDataEvent.progress, initDataEvent.message)
        binding.progressHorizontal.setProgressCompat(initDataEvent.progress, true)
        binding.progressText.text = initDataEvent.message

        if (initDataEvent.progress === Int.MAX_VALUE) {
            binding.progressText.text = getString(R.string.finish)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                val intent = Intent(baseContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 1000)
        }
    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launch {
            EventBus.subscribe<InitDataEvent>().collectLatest { updateProgress(it) }
        }

        val initChampionWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<InitChampionWorker>().build()
        val initItemWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<InitItemWorker>().build()
        WorkManager.getInstance(applicationContext)
                .beginWith(initChampionWorkRequest as OneTimeWorkRequest)
                .then(initItemWorkRequest as OneTimeWorkRequest)
                .enqueue()
    }

}