package com.example.android.fluentcast;

/*
 * Represents transcript in two languages: native and the one which user is learning.
 * */
public class Transcript {
    String mLearningLanguage;
    String mNativeLanguage;

    public Transcript(String learningLanguage, String nativeLanguage) {
        mLearningLanguage = learningLanguage;
        mNativeLanguage = nativeLanguage;
    }

    public String getLearningLanguage() {
        return mLearningLanguage;
    }

    public String getNativeLanguage() {
        return mNativeLanguage;
    }
}
