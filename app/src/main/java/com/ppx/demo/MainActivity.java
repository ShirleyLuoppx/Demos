package com.ppx.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ppx.demo.rajawali.RajawaliActivity;
import com.ppx.demo.scrollerview.DrawerLayoutActivity;
import com.ppx.demo.vr.GifActivity;
import com.ppx.demo.vr.VrActivity;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_gif).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, VrActivity.class)));
        findViewById(R.id.bt_voice_ball).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GifActivity.class)));
        findViewById(R.id.bt_scroller_view).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DrawerLayoutActivity.class)));
        findViewById(R.id.btn_rajawali).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RajawaliActivity.class)));

    }
}
