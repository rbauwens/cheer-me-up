package com.example.cheermeup.fragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheermeup.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends Fragment {

    private List<PhotoRecyclerViewItem> photoItemList = null;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_settings, parent, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {

        RecyclerView settingsRecyclerView = view.findViewById(R.id.card_view_photo_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 4);
        settingsRecyclerView.setLayoutManager(gridLayoutManager);

        if (photoItemList == null) {
            photoItemList = new ArrayList<>();

            photoItemList.add(new PhotoRecyclerViewItem("koala", R.drawable.koala));
            photoItemList.add(new PhotoRecyclerViewItem("penguins", R.drawable.penguins));
        }

        SettingsRecyclerViewDataAdapter settingsDataAdapter = new SettingsRecyclerViewDataAdapter(photoItemList);
        settingsRecyclerView.setAdapter(settingsDataAdapter);
    }
}
