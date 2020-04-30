package com.martahrefs.martian.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.martahrefs.martian.R;

public class MainActivity extends AppCompatActivity {

    // Declare member variables for the class
    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.statButton);

        // Getting data from the EditText
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Store the User's name in a variable
                String name = mNameField.getText().toString();

                // Start story on button click
                startStory(name);
            }
        });
    }

    // Define a Method to start the story
    private void startStory (String userName){
        Intent intent = new Intent(this, StoryActivity.class);
        // Push the name variable through the intent
        intent.putExtra(getString(R.string.key_name), userName);
        // Now start the activity
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}
