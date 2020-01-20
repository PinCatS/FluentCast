package com.example.android.fluentcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class TopicCardAdapter extends ArrayAdapter<TopicCard> {

    public TopicCardAdapter(Context context, List<TopicCard> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.topic_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.cardTitleView = convertView.findViewById(R.id.topic_title);
            viewHolder.podcastCountView = convertView.findViewById(R.id.podcast_count);
            viewHolder.cardImageView = convertView.findViewById(R.id.topic_image);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TopicCard card = getItem(position);

        viewHolder.cardTitleView.setText(card.getTitle());
        viewHolder.podcastCountView.setText(card.getNumberOfPodcasts());
        viewHolder.cardImageView.setImageResource(card.getImageResourceId());

        return convertView;
    }

    private static class ViewHolder {
        TextView cardTitleView;
        TextView podcastCountView;
        ImageView cardImageView;
    }
}
