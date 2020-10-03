package com.example.backgroundtest.speaker

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

/**
 * Class of speaker, it allows to say
 */
class Speaker {
    private val speakerTag = "SPEAKER"
    private lateinit var mTTS: TextToSpeech

    /**
     * Create object of speaker on [context], it is not a constructor or init function
     */
    fun create(context: Context) {
        mTTS = TextToSpeech(context, TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                try {
                    mTTS.language = Locale.ENGLISH
                } catch (e: Exception) {
                    Log.e(speakerTag, e.toString())
                }
            } else {
                Log.e(speakerTag, "Initialization failed")
            }
        })
    }

    /**
     * Says [text]
     */
    fun speak(text: String) {
        val pitch = 1.0f
        val speed = 1.0f

        mTTS.setPitch(pitch)
        mTTS.setSpeechRate(speed)

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null, "speak_id")
    }

    /**
     * Close speaker
     */
    fun close(){
        if(this::mTTS.isInitialized){
            mTTS.stop()
            mTTS.shutdown()
        }
    }
}