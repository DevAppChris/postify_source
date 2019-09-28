package com.android.postify;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

public class BrowserActivity extends AppCompatActivity {
    WebView webView;
    SwipeRefreshLayout swipeRefreshLayout;
    int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Postify-Nutzungsbedingungen");

        setContentView(R.layout.activity_browser);
        webView = findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/index.html");
        swipeRefreshLayout = findViewById(R.id.refresh_swipe_browser);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
            }
        });
    }




}
