package com.example.pmu_lab3

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FilenameEditorActivity : AppCompatActivity() {

    private val PREFS_FILE = "Account"
    private val PREF_NAМE = "Name"
    var settings: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filename_editor)
    }

    fun saveName(view: View) {
        val nameBox = findViewById<View>(R.id.nameBox) as EditText
        val name = nameBox.text.toString()
        // сохраняем его в настройках
        val prefEditor = settings!!.edit()
        prefEditor.putString(PREF_NAМE, name)
        prefEditor.apply()
    }

    fun getName(view: View) {
        val nameView = findViewById<View>(R.id.nameView) as TextView
        val name = settings!!.getString(PREF_NAМE, "n/a")
        nameView.text = name
    }
}