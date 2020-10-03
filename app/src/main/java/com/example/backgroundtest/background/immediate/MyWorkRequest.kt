package com.example.backgroundtest.background.immediate

import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

fun getMyWorkRequest(): WorkRequest {
    return PeriodicWorkRequestBuilder<MyWorker>(15, TimeUnit.MINUTES)
        .setInitialDelay(10, TimeUnit.SECONDS)
        .build()
}