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

package com.example.android.scrollingtext;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * This app displays a scrollable TextView (a magazine article).
 * All changes were made to the layout. No code changes.
 * The code below is part of the Empty Activity template.
 */

public class MainActivity extends AppCompatActivity {
    private TextView mArticle;
    private TextView mShowRandom;
    //private Button mChangeArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArticle = findViewById(R.id.article);
        mShowRandom = findViewById(R.id.showRandom);
        //mChangeArticle = findViewById(R.id.changeArticle);
    }

    public void changeText(View view){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(5);
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        mShowRandom.setBackgroundColor(color);
        mShowRandom.setText(Integer.toString(randomNumber));
        if(randomNumber % 2 == 0) {
            mArticle.setText("I have to do too much homework(classwork).....");
        }
        else{
            mArticle.setText(R.string.article_text);
        }
    }
}
