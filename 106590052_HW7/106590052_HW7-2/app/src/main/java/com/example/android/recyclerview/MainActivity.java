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

package com.example.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import org.apache.commons.io.IOUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.InputStream;
import java.util.LinkedList;

/**
 * Implements a basic RecyclerView that displays a list of generated words.
 * - Clicking an item marks it as clicked.
 * - Clicking the fab button adds a new word to the list.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final LinkedList<String> mRecipeNames = new LinkedList<>();
    private final LinkedList<String> mRecipeDesc = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readFile(getResources().openRawResource(R.raw.recipe_names), mRecipeNames);
        readFile(getResources().openRawResource(R.raw.recipe_desc), mRecipeDesc);
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        WordListAdapter mAdapter = new WordListAdapter(this, mRecipeNames, mRecipeDesc);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void readFile(InputStream ins, LinkedList<String> list) {
        String contents = null;
        String [] contents_array = null;
        int i;
        try{
            contents = IOUtils.toString(ins);
            System.out.println(contents);
            IOUtils.closeQuietly(ins);
        }
        catch (Exception e){
            Log.e(TAG, Log.getStackTraceString(e));
        }

        if (contents != null) {
            contents_array = contents.split("\\r?\\n");
        }
        if (contents_array != null) {
            for (i = 0; i < contents_array.length ; i++){
                list.add(i, contents_array[i]);
                Log.d("ARRAY CONTENTS", contents_array[i]);

            }
        }
    }
}
