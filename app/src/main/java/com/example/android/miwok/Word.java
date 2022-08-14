package com.example.android.miwok;

import android.view.View;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageRecourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageRecourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Get default translation of the word.
     */
    public String  getDefaultTranslation(){
        return mDefaultTranslation;
    }
    /**
     * Get Image resource id
     */
    public int getImageResourceId(){
        return mImageRecourceId;
    }
    /*
    * returns if there is image for a word or not.
    */
    public boolean hasImage(){
        return mImageRecourceId != NO_IMAGE_PROVIDED;
    }
    /**
     * Get Audio resource id
     */
    public int getAudioResourceId(){
        return  mAudioResourceId;
    }
}
