package com.martahrefs.martian.model;


public class Choice {
    /*member Variables of the choice class will be a the text on the buttons and an integer
    * for holding the next page (as an array index)*/
    private String mText;
    private int mNextPage;

    // Create a custom constructor in this class so we can pass fully formed chices
    public Choice (String text, int nextPage){
        mText = text;
        mNextPage = nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
