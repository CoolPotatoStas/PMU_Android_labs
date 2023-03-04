package com.example.pmu_lab3

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.pmu_lab3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding

    private lateinit var nPBar: ProgressBar
    private lateinit var nPBar2: ProgressBar
    private lateinit var nPBar3: ProgressBar

    private var Progress_Status = 0.0
    private var Progress_Status2 = 0.0
    private var Progress_Status3 = 0.0
    private val nHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        nPBar = findViewById<View>(R.id.progressBar1) as ProgressBar
        nPBar2 = findViewById<View>(R.id.progressBar2) as ProgressBar
        nPBar3 = findViewById<View>(R.id.progressBar3) as ProgressBar
        Thread {
            while (Progress_Status < 100) {
                Progress_Status += 0.5
                SystemClock.sleep(50)
                nHandler.post { nPBar.progress = Progress_Status.toInt() }
            }
        }.start()
        Thread {
            while (Progress_Status2 < 100) {
                Progress_Status2 += 0.25
                SystemClock.sleep(50)
                nHandler.post { nPBar2.progress = Progress_Status2.toInt() }
            }
        }.start()
        Thread {
            while (Progress_Status3 < 100) {
                Progress_Status3 += 0.1
                SystemClock.sleep(50)
                nHandler.post { nPBar3.progress = Progress_Status3.toInt() }
            }
        }.start()
        AlertDia()
    }

    fun AlertDia() {
        val alt_bld = AlertDialog.Builder(this)
        alt_bld.setMessage("Диалоговое окно")
            .setCancelable(false)
            .setPositiveButton(
                "Диалог"
            ) { dialogInterface, i -> }
            .setNegativeButton(
                "Окно"
            ) { dialogInterface, i -> dialogInterface.cancel() }
        val alert = alt_bld.create()
        alert.setTitle("Диалоговое окно")
        alert.show()
    }
}