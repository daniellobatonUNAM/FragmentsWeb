package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity: AppCompatActivity() {

    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        myWebView = findViewById(R.id.my_web_view)

        // Configura la WebView
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()

        // Carga una URL
        val url = intent.getStringExtra("url")
        if (url != null) {
            myWebView.loadUrl(url)
        }

    }
}