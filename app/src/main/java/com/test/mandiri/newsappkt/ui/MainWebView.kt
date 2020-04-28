package com.test.mandiri.newsappkt.ui

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.test.mandiri.newsappkt.R
import kotlinx.android.synthetic.main.web_view.*

class MainWebView : AppCompatActivity() {

    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_view)
        url = intent.getStringExtra("url")
        if (intent.hasExtra("title")) {
            title = intent.getStringExtra("title")
        }
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                webView.loadUrl(url)
                return true
            }

            @TargetApi(Build.VERSION_CODES.N)
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                return shouldOverrideUrlLoading(view, request.url.toString())
            }
        }
        webView.loadUrl(url)
    }
}