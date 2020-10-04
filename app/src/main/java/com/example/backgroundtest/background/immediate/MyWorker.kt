package com.example.backgroundtest.background.immediate

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    private val myWorkerTag = "MY_WORKER"

    companion object {
        private var lastWorkTime: Long? = null
    }

    override fun doWork(): Result {
        val workText = "My worker task is done "
        val actualTime = System.currentTimeMillis()
        var timeText = ""

        if (lastWorkTime != null) {
            timeText = "after ${(actualTime - lastWorkTime!!) / 60000} minutes"
        }

        Log.i(myWorkerTag, workText)
        ImmediateManager().getSpeaker()?.speak(workText + timeText)
        lastWorkTime = actualTime

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}