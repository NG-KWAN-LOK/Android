package com.example.a106590052_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mShowCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.count_textView);
        if (savedInstanceState != null){
            String i = savedInstanceState.getString("count_value");
            mShowCount.setText(i);
            count = Integer.parseInt(i);
        }
    }

    public void counting(View view) {
        count ++;
        mShowCount.setText(String.valueOf(count));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count_value", mShowCount.getText().toString());
    }
}
