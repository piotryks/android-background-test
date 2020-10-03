package com.example.backgroundtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.WorkManager
import com.example.backgroundtest.background.immediate.ImmediateManager
import com.example.backgroundtest.speaker.Speaker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val speaker = Speaker()
    private val immediateManager = ImmediateManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

        speaker.create(this)

        immediateManager.setSpeaker(speaker)
        immediateManager.submitMyWork(this)
    }

    private fun setListeners() {
        buttonSpeak.setOnClickListener {
            speaker.speak("Hello")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        WorkManager.getInstance(this).cancelAllWork()
        speaker.close()
    }
}