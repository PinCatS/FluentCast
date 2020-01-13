package com.example.android.fluentcast;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.MissingResourceException;

public class PodcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast);

        String podcastName = getIntent().getStringExtra("EXTRA_PODCAST_NAME");
        if (podcastName == null) {
            throw new MissingResourceException("No podcast name", "TopicActivity.java", "EXTRA_PODCAST_NAME");
        }

        this.setTitle(podcastName);
    }
}
