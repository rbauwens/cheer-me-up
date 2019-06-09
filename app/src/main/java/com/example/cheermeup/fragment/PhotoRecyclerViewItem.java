package com.example.cheermeup.fragment;

public class PhotoRecyclerViewItem {

    // Save photo name.
    private String photoName;

    // Save image resource id.
    private int photoImageId;

    PhotoRecyclerViewItem(String photoName, int photoImageId) {
        this.photoName = photoName;
        this.photoImageId = photoImageId;
    }

    String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    int getPhotoImageId() {
        return photoImageId;
    }

    public void setPhotoImageId(int photoImageId) {
        this.photoImageId = photoImageId;
    }

}
