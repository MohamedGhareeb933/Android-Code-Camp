package com.example.android.miwok;

public class Word {

    public static final int NO_IMAGE_PROVIDED = -1;

    /** Miwok Translation for the App*/
    private String mMiwokTranslation;
    /** English Translation for the App*/
    private String mDefaultTranslation;
    /**Images for Activities*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mMediaPlayerId;


     public Word(int mediaPlayerId,int imageView, String miwokTranslation, String defaultTranslation) {
        mMediaPlayerId = mediaPlayerId;
        mImageResourceId = imageView;
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(int mediaPlayerId ,String miwokTranslation, String defaultTranslation) {
        mMediaPlayerId = mediaPlayerId;
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    /** get the Miwok Translation*/
    public String getMiwok() {
         return mMiwokTranslation;
    }
    /** get the English Translation*/
    public String getDefault() {
         return mDefaultTranslation;
    }
    /** get the English Translation*/
    public int getImageResourceId() {
        return mImageResourceId;
    }
    /**return whether the constructor has an image view or not*/
    public boolean hasImage () {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmMediaPlayerId() { return mMediaPlayerId; }

}
