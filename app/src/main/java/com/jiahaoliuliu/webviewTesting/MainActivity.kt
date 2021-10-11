package com.jiahaoliuliu.webviewTesting

import android.annotation.TargetApi
import android.net.Uri
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import androidx.core.util.Pair

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webview)
        initializeWebViewData()
        webView.loadUrl("https://www.google.com")
    }

    private fun initializeWebViewData() {
        val settings = webView.settings
        webView.scrollBarStyle = WebView.SCROLLBARS_INSIDE_OVERLAY
        webView.isHorizontalScrollBarEnabled = false
        webView.clearCache(true)
        settings.loadWithOverviewMode = true
        settings.javaScriptEnabled = true
        settings.useWideViewPort = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.domStorageEnabled = true
        webView.webViewClient = client
    }

    private val client: WebViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest): Boolean {
            return overrideUrlLoading(request.url)
        }

        private fun overrideUrlLoading(uri: Uri): Boolean {
            return false
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
        }
    }

}