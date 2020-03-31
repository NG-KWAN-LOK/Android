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

package com.example.android.twoactivities;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private int mCount = 0;
    public TextView countView;
    // Unique tag for the intent reply.
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Dev","SecondActivity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the intent that launched this activity, and the message in
        // the intent extra.
        Intent intent = getIntent();
        mCount = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, -1);
        countView = findViewById(R.id.show_count);
        countView.setText(Integer.toString(mCount));

    }

    public void returnReply(View view) {
        // Get the reply message from the edit text.
        String reply = Integer.toString(mCount);

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void countUp(View view) {

        mCount++;
        if (countView != null) {
            Log.d("DEV", "count++");
            countView.setText(Integer.toString(mCount));
        }
    }
}
