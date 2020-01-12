package com.example.android.fluentcast;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class TopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        String topic_name = getIntent().getStringExtra("EXTRA_TOPIC_NAME");
        Log.v("TopicActivity.java", "Topic name: " + topic_name);

        this.setTitle(topic_name);
    }
}
