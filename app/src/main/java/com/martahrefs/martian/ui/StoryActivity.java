package com.martahrefs.martian.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.martahrefs.martian.R;
import com.martahrefs.martian.model.Page;
import com.martahrefs.martian.model.Story;

import static android.R.attr.name;

public class StoryActivity extends AppCompatActivity {

    // Create a new member variable and initialize it as a story object
    private Story mStory= new Story();

    // Member variables for the views we want to manipulate
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Activity is started with an intent, hence can be accessed right away in the OnCreate method
        Intent intent = getIntent();
        // Store the date from the intent in as string variable
        mName = intent.getStringExtra(getString(R.string.key_name));

        // If the user did not pass in their name
        if (mName==null){
            mName = "Friend";
        }

        // Set the respective views variables to their id
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        // Load the page
        loadPage(0);
    }

    // A method that will load a new story onto the screen when the activity is created and when a button is clicked
    private void loadPage (int choice){
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        // Will add the name if placeholder include. It won't add if placeholder is not included.
        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        if (mCurrentPage.isFinal()) {
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());
            // Set Onclick listenes for the two buttons
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    // Now load page with the nextPage variable retrieved above
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    // Now load page with the nextPage variable retrieved above
                    loadPage(nextPage);
                }
            });
        }
    }
}
