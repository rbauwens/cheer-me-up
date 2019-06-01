package com.example.cheermeup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheerMeUpActivity extends AppCompatActivity {

    Button changeImageButton;
    ImageView imageView;
    private int lastResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheer_me_up);

        // Capture the layout's TextView and set the string as it's text
        TextView textView = findViewById(R.id.textView);
        this.lastResourceId = R.drawable.koala;
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        imageView = (ImageView) findViewById(R.id.cheerMeUpImageView);

        changeImageButton = (Button) findViewById(R.id.changeImageButton);
        changeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lastResourceId == R.drawable.koala) {
                    imageView.setImageResource(R.drawable.penguins);
                    lastResourceId = R.drawable.penguins;
                } else {
                    imageView.setImageResource(R.drawable.koala);
                    lastResourceId = R.drawable.koala;
                }
            }
        });
    }




}
