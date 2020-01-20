package com.example.android.fluentcast;

public class TopicCard {

    private final int NO_VALID_IMAGE = -1;
    private final int NO_VALID_COLOR = -1;

    private String mTitle;
    private String mNumberOfPodcasts;
    private int mImageResourceId = -1;
    private int mCardColorResourceId = -1;


    public TopicCard(String title, int numberOfPodcasts) {
        mTitle = title;
        mNumberOfPodcasts = numberOfPodcasts + (numberOfPodcasts > 1 ? " podcasts" : " podcast");
    }

    public TopicCard(String title, int numberOfPodcasts, int imageResourceId, int cardColorResourceId) {
        mTitle = title;
        mNumberOfPodcasts = numberOfPodcasts + (numberOfPodcasts > 1 ? " podcasts" : " podcast");
        mImageResourceId = imageResourceId;
        mCardColorResourceId = cardColorResourceId;
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

    int getCardColorResourceId() {
        return mCardColorResourceId;
    }

    boolean hasValidImage() {
        return mImageResourceId != NO_VALID_IMAGE;
    }

    boolean hasValidColor() {
        return mCardColorResourceId != NO_VALID_COLOR;
    }
}