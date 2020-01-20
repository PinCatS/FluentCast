package com.example.android.fluentcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_list);

        final ArrayList<TopicCard> topics = new ArrayList<>();
        topics.add(new TopicCard("People", 6, R.drawable.people));
        topics.add(new TopicCard("Travelling", 2, R.drawable.travelling));
        topics.add(new TopicCard("Leisure", 2, R.drawable.leisure));
        topics.add(new TopicCard("At home", 1, R.drawable.at_home));
        topics.add(new TopicCard("Technologies", 2, R.drawable.technologies));
        topics.add(new TopicCard("Business", 0, R.drawable.business));
        topics.add(new TopicCard("Cultures", 0, R.drawable.culture));
        topics.add(new TopicCard("Story tails", 0));

        TopicCardAdapter topicCardAdapter = new TopicCardAdapter(this, topics);
        GridView view = findViewById(R.id.topic_list);
        view.setAdapter(topicCardAdapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent topicIntent = new Intent(MainActivity.this, TopicActivity.class);
                TextView textView = v.findViewById(R.id.topic_title);
                topicIntent.putExtra("EXTRA_TOPIC_NAME", textView.getText());
                startActivity(topicIntent);
            }
        });
    }
}
