package com.example.cheermeup.photos;

import android.content.Context;

import com.example.cheermeup.R;
import com.example.cheermeup.fragment.PhotoRecyclerViewItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PhotoList {

    private static String FILENAME = "cheermeup.json";

    private static List<PhotoRecyclerViewItem> photoList;

    public static List<PhotoRecyclerViewItem> getPhotoList() {
        return photoList;
    }

    public static void initialiseList(Context context) {

        File file = new File(context.getFilesDir(), FILENAME);
        if (file.exists()) {
            System.out.println("FILE EXISTS");
            // file exists so we should try and read from it
            Gson gson = new Gson();
            String jsonInput = null;
            try {
                FileInputStream fileInputStream = context.openFileInput(FILENAME);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

                StringBuilder sb = new StringBuilder();
                String line = reader.readLine();

                while (line != null) {
                    sb.append(line);
                    line = reader.readLine();
                }
                jsonInput = sb.toString();
                System.out.println("Reading from file: " + jsonInput);

            } catch (IOException e) {
                e.printStackTrace();
            }

            Type listType = new TypeToken<List<PhotoRecyclerViewItem>>() {}.getType();
            photoList = gson.fromJson(jsonInput, listType);

        } else {
            System.out.println("FILE DOES NOT EXIST");
            // file does not exist so we'll initialize the data and save the file
            if (photoList == null) {
                photoList = new ArrayList<>();

                photoList.add(new PhotoRecyclerViewItem("koala", R.drawable.koala));
                photoList.add(new PhotoRecyclerViewItem("penguins", R.drawable.penguins));
            }
            savePhotoList(context);

        }
    }

    public static void clearList(Context context) {

        File file = new File(context.getFilesDir(), FILENAME);
        if(file.delete()){
            System.out.println(FILENAME + " deleted");
        }else System.out.println(FILENAME + " doesn't exist");

        photoList = null;
    }

    private static void savePhoto(Context context, PhotoRecyclerViewItem photo){
        Gson gson = new Gson();
        String jsonInput;
        List<PhotoRecyclerViewItem> currentList;

        // Read in existing file
        try {

            FileInputStream fileInputStream = context.openFileInput(FILENAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
            jsonInput = sb.toString();
            System.out.println("Reading from file: " + jsonInput);
            Type listType = new TypeToken<List<PhotoRecyclerViewItem>>() {}.getType();
            currentList = gson.fromJson(jsonInput, listType);

            currentList.add(photo);

            String newJson = gson.toJson(currentList, listType);

            File file = new File(context.getFilesDir(), FILENAME);
            if(file.delete()){
                System.out.println(FILENAME + " deleted");
            }else System.out.println(FILENAME + " doesn't exist");

            FileOutputStream outputStream = context.openFileOutput(FILENAME, Context.MODE_APPEND);
            outputStream.write(newJson.getBytes());
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void addPhoto(Context context, PhotoRecyclerViewItem photo) {
        photoList.add(photo);
        savePhoto(context, photo);
    }

    private static void savePhotoList(Context context) {
        // Save initial file

        File file = new File(context.getFilesDir(), FILENAME);
        if (file.exists()) {
            return;
        }
        // file doesn't exist so we'll create it

        // Query free space?

        Type listType = new TypeToken<List<PhotoRecyclerViewItem>>() {}.getType();

        Gson gson = new Gson();
        String json = gson.toJson(photoList, listType);
        try {

            FileOutputStream outputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            outputStream.write(json.getBytes());
            outputStream.flush();
            outputStream.close();
            boolean fileExists = file.exists();
            System.out.println("fileExists: " + fileExists);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}