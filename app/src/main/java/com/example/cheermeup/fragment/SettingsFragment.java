package com.example.cheermeup.fragment;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import com.example.cheermeup.R;
import com.example.cheermeup.activity.SelectPhotoActivity;
import com.example.cheermeup.activity.TakePhotoActivity;
import com.example.cheermeup.photos.PhotoList;

public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        final View inputView =  inflater.inflate(R.layout.fragment_settings, parent, false);

        Button resetPhotosButton = inputView.findViewById(R.id.reset_photos_button);
        resetPhotosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoList.clearList(inputView.getContext());
            }
        });

        Button selectPhotoButton = inputView.findViewById(R.id.add_photos_button);
        selectPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inputView.getContext(), SelectPhotoActivity.class);
                startActivity(intent);
            }
        });

        Button takePhotoButton = inputView.findViewById(R.id.take_photos_button);

        Context context = getContext();
        if (context != null) {
            PackageManager pm = getContext().getPackageManager();
            if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
                takePhotoButton.setVisibility(View.INVISIBLE);
            }
        }

        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inputView.getContext(), TakePhotoActivity.class);
                startActivity(intent);
            }
        });

        return inputView;
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {

        RecyclerView settingsRecyclerView = view.findViewById(R.id.card_view_photo_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 4);
        settingsRecyclerView.setLayoutManager(gridLayoutManager);

        SettingsRecyclerViewDataAdapter settingsDataAdapter = new SettingsRecyclerViewDataAdapter(PhotoList.getPhotoList());
        settingsRecyclerView.setAdapter(settingsDataAdapter);
    }
}
