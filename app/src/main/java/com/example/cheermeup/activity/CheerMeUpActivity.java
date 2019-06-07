package com.example.cheermeup.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cheermeup.R;

public class CheerMeUpActivity extends AppCompatActivity {

    Button changeImageButton;
    ImageView imageView;
    private int lastResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheer_me_up);

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
