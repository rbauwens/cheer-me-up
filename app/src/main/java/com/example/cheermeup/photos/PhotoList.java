package com.example.cheermeup.photos;

import com.example.cheermeup.R;
import com.example.cheermeup.fragment.PhotoRecyclerViewItem;

import java.util.ArrayList;
import java.util.List;

public class PhotoList{

    private static List<PhotoRecyclerViewItem> photoList;

    public static List<PhotoRecyclerViewItem> getPhotoList() {
        return photoList;
    }

    public static void initialiseList() {
        if (photoList == null) {
            photoList = new ArrayList<>();

            photoList.add(new PhotoRecyclerViewItem("koala", R.drawable.koala));
            photoList.add(new PhotoRecyclerViewItem("penguins", R.drawable.penguins));
        }
    }

    public static void clearList() {
        photoList = null;
    }

    public static void addPhoto(PhotoRecyclerViewItem photo) {
        photoList.add(photo);
    }

}
