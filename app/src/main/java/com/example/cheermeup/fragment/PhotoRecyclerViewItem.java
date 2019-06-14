package com.example.cheermeup.fragment;

public class PhotoRecyclerViewItem {

    // Save photo name.
    private String photoName;

    // Save image resource id.
    private int photoImageId;

    private String photoFilePath;

    public PhotoRecyclerViewItem(String photoName, int photoImageId) {
        this.photoName = photoName;
        this.photoImageId = photoImageId;
    }

    public PhotoRecyclerViewItem(String photoName, String filePath) {
        this.photoName = photoName;
        this.photoImageId = 0;
        this.photoFilePath = filePath;
    }

    String getPhotoName() {
        return photoName;
    }

    int getPhotoImageId() {
        return photoImageId;
    }

    String getPhotoFilePath() {
        return photoFilePath;
    }
}
