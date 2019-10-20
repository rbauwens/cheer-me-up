package com.example.cheermeup;

import com.example.cheermeup.fragment.PhotoRecyclerViewItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonProcessingTest {

    @Test
    public void testConvertToAndFromJson() {
        // Set up a photo list
        List<PhotoRecyclerViewItem> photoList;
        photoList = new ArrayList<>();
        photoList.add(new PhotoRecyclerViewItem("koala", R.drawable.koala));
        photoList.add(new PhotoRecyclerViewItem("penguins", R.drawable.penguins));
        for (int i = 0; i < photoList.size(); i++) {
            PhotoRecyclerViewItem nextItem = photoList.get(i);
            System.out.println(nextItem.getPhotoName() + ", " + nextItem.getPhotoImageId());
        }
        // convert list to json
        Gson gson = new Gson();
        Type listType = new TypeToken<List<PhotoRecyclerViewItem>>() {}.getType();
        String json = gson.toJson(photoList, listType);
        System.out.println(json);

        // convert json back to list
        List<PhotoRecyclerViewItem> finalPhotoList = gson.fromJson(json, listType);
        for (int i = 0; i < finalPhotoList.size(); i++) {
            PhotoRecyclerViewItem nextItem = finalPhotoList.get(i);
            System.out.println(nextItem.getPhotoName() + ", " + nextItem.getPhotoImageId());
            assertEquals(photoList.get(i).getPhotoName(), finalPhotoList.get(i).getPhotoName());
            assertEquals(photoList.get(i).getPhotoImageId(), finalPhotoList.get(i).getPhotoImageId());
        }

    }

    @Test
    public void testAppendToJsonList() {
        // Set up a photo list
        List<PhotoRecyclerViewItem> photoList;
        photoList = new ArrayList<>();
        photoList.add(new PhotoRecyclerViewItem("koala", R.drawable.koala));
        photoList.add(new PhotoRecyclerViewItem("penguins", R.drawable.penguins));
        for (int i = 0; i < photoList.size(); i++) {
            PhotoRecyclerViewItem nextItem = photoList.get(i);
            System.out.println(nextItem.getPhotoName() + ", " + nextItem.getPhotoImageId());
        }

        // convert list to json
        Type listType = new TypeToken<List<PhotoRecyclerViewItem>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(photoList, listType);
        System.out.println(json);

        // convert json back to list
        List<PhotoRecyclerViewItem> finalPhotoList = gson.fromJson(json, listType);
        for (int i = 0; i < finalPhotoList.size(); i++) {
            PhotoRecyclerViewItem nextItem = finalPhotoList.get(i);
            System.out.println(nextItem.getPhotoName() + ", " + nextItem.getPhotoImageId());
            assertEquals(photoList.get(i).getPhotoName(), finalPhotoList.get(i).getPhotoName());
            assertEquals(photoList.get(i).getPhotoImageId(), finalPhotoList.get(i).getPhotoImageId());
        }

        // Add one more thing
        PhotoRecyclerViewItem itemToAdd = new PhotoRecyclerViewItem("myNewKoala", R.drawable.koala);
        finalPhotoList.add(itemToAdd);
        String finalJson = gson.toJson(finalPhotoList, listType);
        System.out.println("finalJson: " + finalJson);


    }


    @Test
    public void test2() {
        // Set up a photo list
        List<PhotoRecyclerViewItem> photoList;
        photoList = new ArrayList<>();
        photoList.add(new PhotoRecyclerViewItem("koala", R.drawable.koala));
        photoList.add(new PhotoRecyclerViewItem("penguins", R.drawable.penguins));

        // convert list to json
        Type listType = new TypeToken<List<PhotoRecyclerViewItem>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(photoList, listType);
        System.out.println(json);

        //write json to file
        String filename = "testfile.json";

        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            byte[] strToBytes = json.getBytes();

            outputStream.write(strToBytes);

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read back from file
        try  {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filename), StandardCharsets.UTF_8));
            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        // convert back to list
        List<PhotoRecyclerViewItem> finalPhotoList = gson.fromJson(json, listType);
        for (int i = 0; i < finalPhotoList.size(); i++) {
            PhotoRecyclerViewItem nextItem = finalPhotoList.get(i);
            System.out.println(nextItem.getPhotoName() + ", " + nextItem.getPhotoImageId());
            assertEquals(photoList.get(i).getPhotoName(), finalPhotoList.get(i).getPhotoName());
            assertEquals(photoList.get(i).getPhotoImageId(), finalPhotoList.get(i).getPhotoImageId());
        }

    }
}
