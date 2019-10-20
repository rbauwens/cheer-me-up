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

    public String getPhotoName() {
        return photoName;
    }

    public int getPhotoImageId() {
        return photoImageId;
    }

    public String getPhotoFilePath() {
        return photoFilePath;
    }
}
