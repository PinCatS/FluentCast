package com.example.android.fluentcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

class PodcastAdapter extends ArrayAdapter<Podcast> {

    public PodcastAdapter(Context context, List<Podcast> podcasts) {
        super(context, 0, podcasts);
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {

        PodcastAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.podcast_item, parent, false);

            viewHolder = new PodcastAdapter.ViewHolder();
            viewHolder.podcastTitleView = convertView.findViewById(R.id.podcast_title);
            viewHolder.podcastLevelView = convertView.findViewById(R.id.podcast_level);
            viewHolder.podcastLikesCounterView = convertView.findViewById(R.id.likes_count);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PodcastAdapter.ViewHolder) convertView.getTag();
        }

        Podcast podcast = getItem(position);

        viewHolder.podcastTitleView.setText(podcast.getTitle());
        viewHolder.podcastLevelView.setText(podcast.getLevel());
        viewHolder.podcastLikesCounterView.setText(String.valueOf(podcast.getLikesCounter()));

        return convertView;
    }

    private static class ViewHolder {
        TextView podcastTitleView;
        TextView podcastLevelView;
        TextView podcastLikesCounterView;
    }
}
