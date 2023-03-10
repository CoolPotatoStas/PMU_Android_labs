package com.example.pmu_lab3

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException


class FilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_files)
    }

    fun save(v: View){

        var fos: FileOutputStream? = null

        try {
            val textBox: EditText = findViewById<View>(R.id.saving) as EditText
            val text: String = textBox.getText().toString()
            fos = openFileOutput("test.txt", MODE_PRIVATE)
            fos.write(text.toByteArray())
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show()
        } catch (exception: IOException) {
            Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                if (fos != null) fos.close()
            } catch (exception: IOException) {
                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun open(v: View){

        var fin: FileInputStream? = null
        val textView: TextView = findViewById<View>(R.id.open_text) as TextView
        try {
            fin = openFileInput("test.txt")
            val bytes = ByteArray(fin.available())
            fin.read(bytes)
            val text = String(bytes)
            textView.setText(text)
        } catch (exception: IOException) {
            Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                if (fin != null) fin.close()
            } catch (exception: IOException) {
                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}