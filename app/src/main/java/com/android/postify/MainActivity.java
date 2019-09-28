package com.android.postify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("myPostify");
        actionBar.setLogo(R.drawable.logo_black);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.start_camera:
                Intent camera = new Intent(this, CameraActivity.class);
                startActivity(camera);
                break;
            case R.id.open_profile:
                Intent profile = new Intent(this, ProfilActivity.class);
                startActivity(profile);
                break;
             default:
                 Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
                 break;
        }
        return true;
    }
}
