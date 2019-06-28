package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.net.InetAddress;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    String url = "https://www.lalajiretail.com/";
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        progressBar = findViewById(R.id.progressBar);
        getSupportActionBar().hide();
        webView = findViewById(R.id.webView);
        if(!isInternetAvailable()) {
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onPageCommitVisible(WebView view, String url) {
                    super.onPageCommitVisible(view, url);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    super.onReceivedError(view, request, error);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(WebViewActivity.this, "error : "+error.getDescription(), Toast.LENGTH_SHORT).show();
                }
            });

            webView.loadUrl(url);
        }else{
            Toast.makeText(this, "No internet", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName(url);
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }
}
