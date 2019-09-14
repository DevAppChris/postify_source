package com.android.postify;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

public class BrowserActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Postify-Browser");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setContentView(R.layout.activity_browser);
        webView = findViewById(R.id.webview);

    }



    public boolean onOptionsItemSelected(MenuItem item){
        Intent goBack = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(goBack);
        finish();
        return true;
    }
}
