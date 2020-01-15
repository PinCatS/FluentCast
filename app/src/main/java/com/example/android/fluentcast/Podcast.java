package com.example.android.fluentcast;

public class Podcast {
    String mTitle;
    String mLevel;
    int mLikesCounter;

    public Podcast(String title, String level, int likesCounter) {
        mTitle = title;
        mLevel = level;
        mLikesCounter = likesCounter;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getLevel() {
        return mLevel;
    }

    public int getLikesCounter() {
        return mLikesCounter;
    }

    public void increaseLikesCounter() {
        mLikesCounter++;
    }

    public void decreaseLikesCounter() {
        if (mLikesCounter > 0) mLikesCounter--;
    }
}
