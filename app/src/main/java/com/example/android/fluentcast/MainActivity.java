package com.example.android.fluentcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_list);

        final ArrayList<TopicCard> topics = new ArrayList<>();
        topics.add(new TopicCard("People", 6));
        topics.add(new TopicCard("Travelling", 2));
        topics.add(new TopicCard("Leisure", 2));
        topics.add(new TopicCard("At home", 1));
        topics.add(new TopicCard("Technologies", 2));

        TopicCardAdapter topicCardAdapter = new TopicCardAdapter(this, topics);
        GridView view = findViewById(R.id.topic_list);
        view.setAdapter(topicCardAdapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent topicIntent = new Intent(MainActivity.this, TopicActivity.class);
                topicIntent.putExtra("EXTRA_TOPIC_NAME", parent.getItemAtPosition(position).toString());
                startActivity(topicIntent);
            }
        });
    }
}
