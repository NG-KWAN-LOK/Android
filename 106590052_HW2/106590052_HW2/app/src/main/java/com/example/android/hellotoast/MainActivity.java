/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.hellotoast;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Displays two Buttons and a TextView.
 * - Pressing the TOAST button shows a Toast.
 * - Pressing the COUNT button increases the displayed mCount.
 *
 * Note: Fixing behavior when device is rotated is a challenge exercise for the student.
 */

public class MainActivity extends AppCompatActivity {
    private static final String STATE_COUNTER = "counter";
    private int mCount = 0;
    private TextView mShowCount;
    private Button mSetZeroButton;
    private Button mCountUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(STATE_COUNTER, 0);
        }
        mShowCount = (TextView) findViewById(R.id.show_count);
        mShowCount.setText(Integer.toString(mCount));
        mSetZeroButton = findViewById(R.id.button_zero);
        mCountUpButton = findViewById(R.id.button_count);
        setButtonColor();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNTER, mCount);
    }
    /*
    * Shows a Toast when the TOAST button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since a toast always shows on the top,
    *             the passed in view is not used.
    */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void setZero(View view) {
        mCount = 0;
        mShowCount.setText(Integer.toString(mCount));
        mSetZeroButton.setBackgroundColor(getResources().getColor(R.color.gray));
        mCountUpButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    /*
    * Increments the number in the TextView when the COUNT button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since the count always appears in the TextView,
    *             the passed in view is not used.
    */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        setButtonColor();
    }
    public void  setButtonColor(){
        if(mCount % 2 == 0)
            mCountUpButton.setBackgroundColor(getResources().getColor(R.color.black));
        else
            mCountUpButton.setBackgroundColor(getResources().getColor(R.color.orange));
        if(mCount > 0) {
            mSetZeroButton.setBackgroundColor(getResources().getColor(R.color.pink));
        }
    }
}
