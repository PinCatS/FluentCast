package com.example.android.fluentcast;

public class TopicCard {
    private String mTitle;
    private String mNumberOfPodcasts;
    private int mImageResourceId;

    public TopicCard(String title, int numberOfPodcasts) {
        mTitle = title;
        mNumberOfPodcasts = numberOfPodcasts + (numberOfPodcasts > 1 ? " podcasts" : " podcast");
    }

    public TopicCard(String title, int numberOfPodcasts, int imageResourceId) {
        mTitle = title;
        mNumberOfPodcasts = numberOfPodcasts + (numberOfPodcasts > 1 ? " podcasts" : " podcast");
        mImageResourceId = imageResourceId;
    }

    String getTitle() {
        return mTitle;
    }

    String getNumberOfPodcasts() {
        return mNumberOfPodcasts;
    }

    int getImageResourceId() {
        return mImageResourceId;
    }
}