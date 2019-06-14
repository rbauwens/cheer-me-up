package com.example.cheermeup.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cheermeup.R;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public class SettingsRecyclerViewDataAdapter extends RecyclerView.Adapter<PhotoRecyclerViewItemHolder> {

    private List<PhotoRecyclerViewItem> photoList;

    SettingsRecyclerViewDataAdapter(List<PhotoRecyclerViewItem> photoItemList) {
        this.photoList = photoItemList;
    }

    @NotNull
    @Override
    public PhotoRecyclerViewItemHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View photoItemView = layoutInflater.inflate(R.layout.activity_card_view_item, parent, false);

        final TextView photoTitleView = photoItemView.findViewById(R.id.card_view_image_title);
        final ImageView photoImageView = photoItemView.findViewById(R.id.card_view_image);

        // When click the image.
        photoItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String photoTitle = photoTitleView.getText().toString();
                // Create a snackbar and show it.
                Snackbar snackbar = Snackbar.make(photoImageView, "You clicked " + photoTitle +" image", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        // Create and return our custom Car Recycler View Item Holder object.
        return new PhotoRecyclerViewItemHolder(photoItemView);
    }
    @Override
    public void onBindViewHolder(@NotNull PhotoRecyclerViewItemHolder holder, int position) {
        if(photoList!=null) {
            // Get item dto in list.
            PhotoRecyclerViewItem photoItem = photoList.get(position);

            if(photoItem != null) {
                // Set item title.
                holder.getPhotoTitleText().setText(photoItem.getPhotoName());
                // Set image resource id.

                if (photoItem.getPhotoImageId() != 0) {
                    holder.getPhotoImageView().setImageResource(photoItem.getPhotoImageId());
                } else if (photoItem.getPhotoFilePath() != null) {
                    File imageFile = new File(photoItem.getPhotoFilePath());
                    if (imageFile.exists()) {
                        holder.getPhotoImageView().setImageBitmap(BitmapFactory.decodeFile(photoItem.getPhotoFilePath()));
                    }
                }

            }
        }
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(photoList!=null)
        {
            ret = photoList.size();
        }
        return ret;
    }

}
