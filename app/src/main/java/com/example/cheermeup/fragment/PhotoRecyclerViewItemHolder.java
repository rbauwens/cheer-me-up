package com.example.cheermeup.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheermeup.R;

class PhotoRecyclerViewItemHolder extends RecyclerView.ViewHolder {

    private TextView photoTitleText;
    private ImageView photoImageView;

    PhotoRecyclerViewItemHolder(View itemView) {
        super(itemView);

        photoTitleText = itemView.findViewById(R.id.card_view_image_title);

        photoImageView = itemView.findViewById(R.id.card_view_image);
    }

    TextView getPhotoTitleText() {
        return photoTitleText;
    }

    ImageView getPhotoImageView() {
        return photoImageView;
    }
}
