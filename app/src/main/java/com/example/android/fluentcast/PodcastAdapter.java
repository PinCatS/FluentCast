package com.example.android.fluentcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

class PodcastAdapter extends ArrayAdapter<Podcast> {

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            Podcast podcast = getItem(position);
            if (podcast.wasLiked()) {
                podcast.decreaseLikesCounter();
            } else {
                podcast.increaseLikesCounter();
            }
            notifyDataSetChanged();
        }
    };

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
            viewHolder.likesButton = convertView.findViewById(R.id.likes_icon);

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

        if (!podcast.wasLiked()) {
            viewHolder.likesButton.setImageResource(R.mipmap.podcast_like_icon);
        } else {
            viewHolder.likesButton.setImageResource(R.mipmap.podcast_like_filled_icon);
        }
        viewHolder.likesButton.setOnClickListener(mClickListener);
        viewHolder.likesButton.setTag(position);


        return convertView;
    }

    private static class ViewHolder {
        TextView podcastTitleView;
        TextView podcastLevelView;
        TextView podcastLikesCounterView;
        ImageView likesButton;
    }
}
