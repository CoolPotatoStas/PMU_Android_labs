package com.example.pmu_lab3

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.pmu_lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            getString(R.string.channel_name),
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = getString(R.string.channel_description)
        getSystemService(
            NotificationManager::class.java
        ).createNotificationChannel(channel)
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toast = Toast.makeText(applicationContext, "Загрузка прошла успешно", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 500, 500)
        toast.show()
        createNotificationChannel()

        val snoozeIntent = Intent(this, BroadcastReceiver::class.java)
        snoozeIntent.action = ACTION_SNOOZE
        snoozeIntent.putExtra(EXTRA_NOTIFIC_ID, 0)
        val contentintent = PendingIntent.getActivity(
            applicationContext,
            0, Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")),
            PendingIntent.FLAG_CANCEL_CURRENT
        )
        val mBuilder: NotificationCompat.Builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_car)
            .setColor(Color.RED)
            .setContentTitle("Goooooooogle")
            .setContentText("https://www.google.com/")
            .setTicker("Info").setWhen(System.currentTimeMillis())
            .setContentIntent(contentintent)
            .addAction(R.drawable.sharp_lock, getString(R.string.snooze), PendingIntent.getBroadcast(this, 0, snoozeIntent, 0))
            .setPriority(NotificationCompat.PRIORITY_MAX)
        val notification = mBuilder.build()
        val notificationManager =
            applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFY_ID, notification)
    }

    fun on_click(v: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun menu_click(v: View) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    fun transitions_click(v: View) {
        val intent = Intent(this, TransitionActivity::class.java)
        startActivity(intent)
    }

    fun workWithFilesClick(v: View){
        val intent = Intent(this, FilesActivity::class.java)
        startActivity(intent)
    }

    fun workWithFilename(v: View){
        val intent = Intent(this, FilenameEditorActivity::class.java)
        startActivity(intent)
    }

    fun workWithDatabase(v: View){
        val intent = Intent(this, DatabaseActivity::class.java)
        startActivity(intent)
    }

    fun workWithBrowse(v: View){
        val intent = Intent(this, WebBrowseActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private const val NOTIFY_ID = 101
        private const val CHANNEL_ID = "MyChannel"
        private const val ACTION_SNOOZE = "But1"
        private const val EXTRA_NOTIFIC_ID = "But2"
    }
}