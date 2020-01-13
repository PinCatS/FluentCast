package com.example.android.fluentcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class TopicCardAdapter extends ArrayAdapter<TopicCard> {

    public TopicCardAdapter(Context context, List<TopicCard> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.topic_item, parent, false);
        }

        TopicCard card = getItem(position);

        TextView textView = convertView.findViewById(R.id.topic_title);
        textView.setText(card.getTitle());

        textView = convertView.findViewById(R.id.podcast_count);
        textView.setText(card.getNumberOfPodcasts());

        return convertView;
    }
}
