package com.example.pmu_lab3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors

class WebBrowseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_browse)
//        val policy = ThreadPolicy.Builder().permitAll().build()
//        StrictMode.setThreadPolicy(policy)
    }

    fun browse(v: View) {
        val browser = findViewById<View>(R.id.webview) as WebView
        browser.loadUrl("https://github.com/CoolPotatoStas/PMU_Android_labs/commits/main")
        print(browser.originalUrl)
    }

    fun customHttpRequest(v: View) {
        try {
            val thread = Thread {
                try {
                    val httpclient: HttpClient = DefaultHttpClient()
                    val httpRequest =
                        HttpGet("http://192.168.0.107:8080/hello")
                    val httpResponse = httpclient.execute(httpRequest)
                    Log.i("serverAnswer++++", httpResponse.statusLine.statusCode.toString())
                    val text: String = BufferedReader(
                        InputStreamReader(httpResponse.entity.content, StandardCharsets.UTF_8)
                    )
                        .lines()
                        .collect(Collectors.joining("\n"))
                    Log.i("serverAnswer++++", text)
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }

            thread.start()
            Log.i("myTag++++", "OK")
        } catch (e: Exception) {
            Log.e("myError+++", e.toString())
        }


    }
}