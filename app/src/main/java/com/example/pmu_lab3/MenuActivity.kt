package com.example.pmu_lab3

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btn = findViewById<View>(R.id.Track) as Button

        volumeControlStream = AudioManager.STREAM_MUSIC

        val mediaPlayer = MediaPlayer()
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer.setDataSource("https://r.mradx.net/img/FF/36D9E9.mp3")
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener { mediaPlayer.start() }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        btn.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        title = "Меню"
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}