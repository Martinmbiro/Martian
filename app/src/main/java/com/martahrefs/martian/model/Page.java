package com.martahrefs.martian.model;


public class Page {
    /* Add member ariables for all the data that will be included on the page
    There will be
    - Image
    - A story Text
    - 2 button choices
    */
    // Images will be stored in Drawable folders and will be referenced using their id
    private int mImageId;
    private String mText;
    // There will be two choices on each page, so lets use the choice class created
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal = false;

    // Create a new constructor that passes 4 parameters to match the 4 member variables
    public Page (int imageId, String text, Choice choice1, Choice choice2){
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }

    // Create another constructor that doesn't have choices, but rather the imageId and Text
    public Page (int imageId, String text){
        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean aFinal) {
        mIsFinal = aFinal;
    }
}
