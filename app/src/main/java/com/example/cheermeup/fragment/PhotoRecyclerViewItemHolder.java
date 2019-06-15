package com.example.cheermeup.fragment;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheermeup.R;

class PhotoRecyclerViewItemHolder extends RecyclerView.ViewHolder {

    private ImageView photoImageView;

    PhotoRecyclerViewItemHolder(View itemView) {
        super(itemView);
        photoImageView = itemView.findViewById(R.id.card_view_image);
    }

    ImageView getPhotoImageView() {
        return photoImageView;
    }
}
