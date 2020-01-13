package com.example.android.fluentcast;

public class TopicCard {
    private String mTitle;
    private String mNumberOfPodcasts;

    public TopicCard(String title, int numberOfPodcasts) {
        this.mTitle = title;
        this.mNumberOfPodcasts = numberOfPodcasts + (numberOfPodcasts > 1 ? " podcasts" : " podcast");
    }

    String getTitle() {
        return mTitle;
    }

    String getNumberOfPodcasts() {
        return mNumberOfPodcasts;
    }
}