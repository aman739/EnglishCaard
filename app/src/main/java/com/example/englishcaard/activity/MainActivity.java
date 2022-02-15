package com.example.englishcaard.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.englishcaard.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_EnglishCaard);
        setContentView(R.layout.activity_main);


    }
}