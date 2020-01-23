package com.example.android.fluentcast;

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
