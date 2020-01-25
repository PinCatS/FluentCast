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

        /*
         * Adding list of podcast topics. In reality they will be fetched from the server
         * */
        final ArrayList<TopicCard> topics = new ArrayList<>();
        topics.add(new TopicCard("People", 6, R.drawable.people, R.color.people_card_color));
        topics.add(new TopicCard("Travelling", 2, R.drawable.travelling, R.color.travelling_card_color));
        topics.add(new TopicCard("Leisure", 2, R.drawable.leisure, R.color.leisure_card_color));
        topics.add(new TopicCard("At home", 1, R.drawable.at_home, R.color.home_card_color));
        topics.add(new TopicCard("Technologies", 2, R.drawable.technologies, R.color.technologies_card_color));
        topics.add(new TopicCard("Business", 0, R.drawable.business, R.color.business_card_color));
        topics.add(new TopicCard("Cultures", 0, R.drawable.culture, R.color.culture_card_color));

        TopicCardAdapter topicCardAdapter = new TopicCardAdapter(this, topics);
        GridView view = findViewById(R.id.topic_list);
        view.setAdapter(topicCardAdapter);

        /*
         * Send an explicit intent to open podcast activity.
         * Pass to the activity the topic name which was clicked.
         * */
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
