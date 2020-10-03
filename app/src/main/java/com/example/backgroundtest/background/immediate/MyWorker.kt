package com.example.backgroundtest.background.immediate

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    private val myWorkerTag = "MY_WORKER"

    override fun doWork(): Result {

        val workText = "My worker task is done"
        Log.i(myWorkerTag, workText)
        ImmediateManager().getSpeaker()?.speak(workText)

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}