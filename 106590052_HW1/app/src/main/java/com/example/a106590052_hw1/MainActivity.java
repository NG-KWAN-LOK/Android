package com.example.a106590052_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello World");
        Log.d("MainActivity", "This is a debug log.");
        Log.e("MainActivity", "This is a error log.");
        Log.w("MainActivity", "This is a warn log.");
        Log.i("MainActivity", "This is a info log.");
    }
}
