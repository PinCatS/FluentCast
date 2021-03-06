package com.example.android.fluentcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.MissingResourceException;

/*
 * The TopicActivity is called from MainActivity.
 * User is directed here when he clicks on the topic.
 * The activity lists all available podcasts related to the
 * topic user clicked.
 * Here they could like any podcast or click on it.
 * After clicking, user will be directed to PodcastActivity
 * where they are able to play podcast and read transcript if
 * available.
 *
 * */
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

        /*
         * In the future podcasts will be loaded from the server by key
         * or identifier. But now use the switch statement for this.
         *
         * */
        final ArrayList<Podcast> podcasts = new ArrayList<>();
        switch (topic_name) {
            case "People":
                podcasts.add(new Podcast("Hello! My name is Maria", "elementary", 67));
                podcasts.add(new Podcast("I can't talk now", "elementary", 15));
                podcasts.add(new Podcast("Can you do me a favor?", "pre-intermediate", 34));
                podcasts.add(new Podcast("Excuse me!", "elementary", 23));
                podcasts.add(new Podcast("I'm sorry!", "elementary", 89));
                podcasts.add(new Podcast("Caring about others", "intermediate", 132));
                break;
            case "Travelling":
                podcasts.add(new Podcast("Check in at the airport", "intermediate", 287));
                podcasts.add(new Podcast("Asking for the place", "intermediate", 58));
                break;
            case "Leisure":
                podcasts.add(new Podcast("In the restaurant", "intermediate", 598));
                podcasts.add(new Podcast("Asking for the menu", "pre-intermediate", 165));
                break;
            case "At home":
                podcasts.add(new Podcast("Returning clothes", "intermediate", 287));
                break;
            case "Technologies":
                podcasts.add(new Podcast("Setting up an interview", "upper-intermediate", 54));
                podcasts.add(new Podcast("Can't open the link", "pre-intermediate", 48));
                break;
            case "Business":
                break;
            case "Cultures":
                break;
            case "Story tails":
                break;
            default:
                throw new IllegalArgumentException("Unrecognized podcast category: " + topic_name);
        }

        PodcastAdapter podcastAdapter = new PodcastAdapter(this, podcasts);
        ListView podcastList = findViewById(R.id.podcast_list);
        podcastList.setAdapter(podcastAdapter);

        /*
         * Use explicit intent to start PodcastAcitvity.
         * Pass podcast name to it.
         *
         * */
        podcastList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent podcastIntent = new Intent(TopicActivity.this, PodcastActivity.class);
                TextView textView = v.findViewById(R.id.podcast_title);
                podcastIntent.putExtra("EXTRA_PODCAST_NAME", textView.getText());
                startActivity(podcastIntent);
            }
        });
    }
}
