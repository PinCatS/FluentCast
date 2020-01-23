package com.example.android.fluentcast;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
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

        LinearLayout playControlLayout = findViewById(R.id.podcast_play_control);
        playControlLayout.setVisibility(View.VISIBLE);

        ArrayList<String> transcriptsArray = new ArrayList<>();
        transcriptsArray.add("Hi! My name is Sergey1");
        transcriptsArray.add("Hi! My name is Sergey2");
        transcriptsArray.add("Hi! My name is Sergey3");
        transcriptsArray.add("Hi! My name is Sergey4");
        transcriptsArray.add("Hi! My name is Sergey5");
        transcriptsArray.add("Hi! My name is Sergey6");
        transcriptsArray.add("Hi! My name is Sergey7");
        transcriptsArray.add("Hi! My name is Sergey8");
        transcriptsArray.add("Hi! My name is Sergey9");
        transcriptsArray.add("Hi! My name is Sergey10");
        transcriptsArray.add("Hi! My name is Sergey11");
        transcriptsArray.add("Hi! My name is Sergey12");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");
        transcriptsArray.add("Hi! My name is Sergey13");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, transcriptsArray);
        ListView listView = findViewById(R.id.transcript_list);
        listView.setAdapter(arrayAdapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            private int lastVisibleItem = 0;
            private int lastY = 0;
            private final LinearLayout playControlLayout = findViewById(R.id.podcast_play_control);

            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int top = 0;

                if (view.getChildAt(0) != null) {
                    top = view.getChildAt(0).getTop();
                }

                if (firstVisibleItem > lastVisibleItem) {
                    Log.v("PodcastActivity.java", "onScroll: scroll down");
                    playControlLayout.setVisibility(View.INVISIBLE);
                } else if (firstVisibleItem < lastVisibleItem) {
                    Log.v("PodcastActivity.java", "onScroll: scroll up");
                    playControlLayout.setVisibility(View.VISIBLE);
                } else {
                    if (top < lastY) {
                        Log.v("PodcastActivity.java", "onScroll: else scroll down");
                        playControlLayout.setVisibility(View.INVISIBLE);
                    } else if (top > lastY) {
                        Log.v("PodcastActivity.java", "onScroll: else scroll up");
                        playControlLayout.setVisibility(View.VISIBLE);
                    }
                }

                lastVisibleItem = firstVisibleItem;
                lastY = top;

            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
    }
}
