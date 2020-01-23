package com.example.android.fluentcast;

public class Podcast {
    private String mTitle;
    private String mLevel;
    private int mLikesCounter;
    private boolean liked = false;

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
        like();
    }

    public void decreaseLikesCounter() {
        if (mLikesCounter > 0) {
            mLikesCounter--;
            unlike();
        }
    }

    public boolean wasLiked() {
        return liked;
    }

    private void like() {
        liked = true;
    }

    private void unlike() {
        liked = false;
    }
}
