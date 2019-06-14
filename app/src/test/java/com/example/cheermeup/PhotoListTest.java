package com.example.cheermeup;

import com.example.cheermeup.fragment.PhotoRecyclerViewItem;
import com.example.cheermeup.photos.PhotoList;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the photo list class
 */
public class PhotoListTest {

    @Before
    public void setup_list() {
        PhotoList.clearList();
    }

    @Test
    public void photo_list_initialise() {
        assertNull(PhotoList.getPhotoList());
        PhotoList.initialiseList();
        assertNotEquals(PhotoList.getPhotoList().size(), 0);
    }

    @Test
    public void photo_list_initial_size() {
        PhotoList.initialiseList();
        assertEquals(PhotoList.getPhotoList().size(), 2);
    }

    @Test
    public void photo_list_clear() {
        assertNull(PhotoList.getPhotoList());
        PhotoList.initialiseList();
        assertNotEquals(PhotoList.getPhotoList().size(), 0);
        PhotoList.clearList();
        assertNull(PhotoList.getPhotoList());
    }

    @Test
    public void add_photo(){
        PhotoList.initialiseList();
        assertEquals(PhotoList.getPhotoList().size(), 2);
        PhotoRecyclerViewItem photo = new PhotoRecyclerViewItem("launcher", R.drawable.ic_launcher_foreground);
        PhotoList.addPhoto(photo);

        assertEquals(PhotoList.getPhotoList().size(), 3);
        List<PhotoRecyclerViewItem> photoList = PhotoList.getPhotoList();
        assertTrue(photoList.contains(photo));
    }
}