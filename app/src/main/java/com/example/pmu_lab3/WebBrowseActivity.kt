package com.example.pmu_lab3

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class WebBrowseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_browse)
    }

    fun Brows(v: View?) {
        val browser = findViewById<View>(R.id.webview) as WebView
        browser.loadUrl("https://github.com/HeapGeap")
    }
}