package com.example.firstapp

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.firstapp.worker.InitDataWorker
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/11
 **/
@HiltAndroidApp
class App : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration() = Configuration.Builder().setWorkerFactory(workerFactory).build()

    override fun onCreate() {
        super.onCreate()

        val initDataWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<InitDataWorker>().build()
        WorkManager.getInstance(applicationContext).enqueue(initDataWorkRequest)
    }
}