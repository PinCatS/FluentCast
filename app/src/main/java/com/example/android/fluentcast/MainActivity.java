package com.example.android.fluentcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_list);

        final ArrayList<String> topics = new ArrayList<>();
        topics.add("People");
        topics.add("Travelling");
        topics.add("Leisure");
        topics.add("At home");
        topics.add("Technologies");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, topics);
        GridView view = findViewById(R.id.topic_list);
        view.setAdapter(arrayAdapter);

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
