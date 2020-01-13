package com.example.android.fluentcast;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.MissingResourceException;

public class TopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.podcast_list);

        String topic_name = getIntent().getStringExtra("EXTRA_TOPIC_NAME");
        if (topic_name == null) {
            throw new MissingResourceException("No topic name", "TopicActivity.java", "EXTRA_TOPIC_NAME");
        }

        this.setTitle(topic_name);

        final ArrayList<String> podcasts = new ArrayList<>();
        /*
         * In the future podcasts will be loaded from the server by key
         * or identifier. But now use the switch statement for this.
         *
         * */
        switch (topic_name) {
            case "People":
                podcasts.add("Hi! My name is Peter");
                podcasts.add("I can't talk now");
                podcasts.add("Can you do me a favor?");
                podcasts.add("Excuse me!");
                podcasts.add("I'm sorry!");
                podcasts.add("Caring about others");
                break;
            case "Travelling":
                podcasts.add("Check in at the airport");
                podcasts.add("Asking for the place");
                break;
            case "Leisure":
                podcasts.add("In the restaurant");
                podcasts.add("Asking for the menu");
                break;
            case "At home":
                podcasts.add("Returning clothes");
                break;
            case "Technologies":
                podcasts.add("Setting up an interview");
                podcasts.add("Can't open the link");
                break;
            default:
                throw new IllegalArgumentException("Unrecognized podcast category: " + topic_name);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, podcasts);
        ListView podcastList = findViewById(R.id.podcast_list);
        podcastList.setAdapter(arrayAdapter);
    }
}
