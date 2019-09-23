package com.android.postify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;

public class SplashScreenActivity extends AppCompatActivity {
        private static int SPLASH_TIME_OUT = 2500;
    boolean connected = false;
        int critical_emoji = 0x1F62C;
        int nice_emoji = 0x1F917;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    connected = true;
                } else {
                    connected = false;
                        Toast.makeText(SplashScreenActivity.this, "Es konnte keine Internetverbindung gefunden werden " + getEmojiByUnicode(critical_emoji), Toast.LENGTH_LONG).show();
                        Toast.makeText(SplashScreenActivity.this, "Verbinde dich mit dem Internet und starte die App erneut "+getEmojiByUnicode(nice_emoji), Toast.LENGTH_LONG).show();

                }
                if (connected == true) {
                    Intent login = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(login);
                    finish();
                }


            }
        }, SPLASH_TIME_OUT);
    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
