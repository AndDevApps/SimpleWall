package com.example.andrew.gall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

public class favourite extends MainActivity {

    Gallery simpleGallery;
    CustomGalleryAdapter customGalleryAdapter;
    ImageView selectedImageView;
    int a,b,c,d;
    int[] images = {a,b,c,d} ;
    MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        Intent intent = getIntent();
        simpleGallery = findViewById(R.id.simpleGallery); // get the reference of Gallery
        selectedImageView = findViewById(R.id.selectedImageView); // get the reference of ImageView
        customGalleryAdapter = new CustomGalleryAdapter(getApplicationContext(), images); // initialize the adapter
        simpleGallery.setAdapter(customGalleryAdapter); // set the adapter
        simpleGallery.setSpacing(20); //было 10
        //int m = main.getCount();
        int count = getIntent().getIntExtra("count",0);

        switch (count)
        {
            case 0:
                a = R.drawable.w1;
                break;
            case 1:
                a = R.drawable.w2;
                break;
            case 2:
                a = R.drawable.w3;
                break;
            case 3:
                a = R.drawable.w4;
                break;
        }


        simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedImageView.setImageResource(images[position]);// set the selected image in the ImageView
            }
        });

    }
}
