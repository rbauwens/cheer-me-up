package com.example.cheermeup.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.cheermeup.R;

public class CheerMeUpFragment extends Fragment {
    Button changeImageButton;
    ImageView imageView;
    private int lastResourceId;


    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation. 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.activity_cheer_me_up, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        this.lastResourceId = R.drawable.koala;
        addListenerOnButton(view);
    }

    public void addListenerOnButton(View view) {
        imageView = (ImageView) view.findViewById(R.id.cheerMeUpImageView);

        changeImageButton = (Button) view.findViewById(R.id.changeImageButton);
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