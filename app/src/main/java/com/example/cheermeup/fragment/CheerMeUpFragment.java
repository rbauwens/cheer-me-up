package com.example.cheermeup.fragment;

import java.io.File;
import java.util.List;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import com.example.cheermeup.R;
import com.example.cheermeup.photos.PhotoList;

public class CheerMeUpFragment extends Fragment {
    private ImageView imageView;
    private int photoIndex;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cheer_me_up, parent, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {

        // Set initial image
        imageView = view.findViewById(R.id.cheerMeUpImageView);
        List<PhotoRecyclerViewItem> photoList = PhotoList.getPhotoList();
        int photoId = photoList.get(0).getPhotoImageId();
        this.photoIndex = 0;
        imageView.setImageResource(photoId);

        addListenerOnButton(view);
    }

    private void addListenerOnButton(View view) {
        imageView = view.findViewById(R.id.cheerMeUpImageView);

        Button changeImageButton = view.findViewById(R.id.changeImageButton);
        changeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<PhotoRecyclerViewItem> photoList = PhotoList.getPhotoList();
                photoIndex = (photoIndex + 1) % PhotoList.getPhotoList().size();

                PhotoRecyclerViewItem photo = photoList.get(photoIndex);

                int photoId = photo.getPhotoImageId();
                if (photoId == 0) {
                    String filePath = photo.getPhotoFilePath();
                    File imageFile = new File(filePath);
                    if (imageFile.exists()) {
                        imageView.setImageBitmap(BitmapFactory.decodeFile(filePath));
                    }
                } else {
                    imageView.setImageResource(photoId);
                }
            }
        });
    }
}