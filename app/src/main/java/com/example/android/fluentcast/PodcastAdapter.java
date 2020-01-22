package com.example.android.fluentcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

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
        String level = podcast.getLevel();
        viewHolder.podcastLevelView.setText(level);
        if (level == "elementary") {
            viewHolder.podcastLevelView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.language_level_tag_elementary_background));
        } else if (level == "pre-intermediate") {
            viewHolder.podcastLevelView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.language_level_tag_preintermediate_background));
        } else if (level == "intermediate") {
            viewHolder.podcastLevelView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.language_level_tag_intermediate_background));
        } else if (level == "upper-intermediate") {
            viewHolder.podcastLevelView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.language_level_tag_upper_intermediate_background));
        }
        viewHolder.podcastLikesCounterView.setText(String.valueOf(podcast.getLikesCounter()));

        return convertView;
    }

    private static class ViewHolder {
        TextView podcastTitleView;
        TextView podcastLevelView;
        TextView podcastLikesCounterView;
    }
}
