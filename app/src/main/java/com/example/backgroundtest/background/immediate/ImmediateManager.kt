package com.example.backgroundtest.background.immediate

import android.content.Context
import androidx.work.WorkManager
import com.example.backgroundtest.speaker.Speaker

/**
 * Class of immediate background tasks.
 * Use when the task need to complete while the user is interacting with the application!!!
 */
class ImmediateManager {
    private companion object Companion{
        var speaker: Speaker? = null
    }

    /**
     * Set [speaker] to class
     */
    fun setSpeaker(speaker: Speaker) {
        Companion.speaker = speaker
    }

    /**
     * Return Speaker instance
     */
    fun getSpeaker(): Speaker? {
        return Companion.speaker
    }

    /**
     * Submit MyWork in WorkManager by [context]
     */
    fun submitMyWork(context: Context) {
        WorkManager
            .getInstance(context)
            .enqueue(getMyWorkRequest())
    }
}