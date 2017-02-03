/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ParseObject score = new ParseObject("Score"); // provide a class name
    score.put("username", "rob"); // key as variable, value as value
    score.put("score", 86);
    score.saveInBackground(new SaveCallback() {
        @Override
        public void done(ParseException e) {

            if (e == null) {

                Log.i("SaveInBackground", "Successful");

            } else {

                Log.i("SaveInBackground", "Failed. Error: " + e.toString());

            }
        }
    });

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}
