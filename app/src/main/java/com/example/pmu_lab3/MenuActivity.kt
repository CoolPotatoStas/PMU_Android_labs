package com.example.pmu_lab3

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        title = "Меню"
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}