package com.example.cheermeup.fragment;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.example.cheermeup.R;
import com.example.cheermeup.activity.SelectPhotoActivity;
import com.example.cheermeup.photos.PhotoList;

public class SettingsFragment extends Fragment {

    public SettingsRecyclerViewDataAdapter settingsDataAdapter;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        final View inputView =  inflater.inflate(R.layout.fragment_settings, parent, false);

        Button selectPhotoButton = inputView.findViewById(R.id.add_photos_button);
        selectPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inputView.getContext(), SelectPhotoActivity.class);
                startActivity(intent);
            }
        });
        return inputView;
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        if (settingsDataAdapter != null) {
            settingsDataAdapter.notifyDataSetChanged();
        }

        RecyclerView settingsRecyclerView = view.findViewById(R.id.card_view_photo_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 4);
        settingsRecyclerView.setLayoutManager(gridLayoutManager);

        settingsDataAdapter = new SettingsRecyclerViewDataAdapter(PhotoList.getPhotoList());
        settingsRecyclerView.setAdapter(settingsDataAdapter);
    }

    public String getTitle() {
        return getString(R.string.nav_settings);
    }



}
