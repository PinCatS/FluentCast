package com.example.android.fluentcast;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> topics = new ArrayList<>();
        topics.add("People");
        topics.add("Travelling");
        topics.add("Leisure");
        topics.add("At home");
        topics.add("Technologies");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, topics);
        ListView view = findViewById(R.id.topic_list);
        view.setAdapter(arrayAdapter);

    }
}
