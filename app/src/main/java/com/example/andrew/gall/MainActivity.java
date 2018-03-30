package com.example.andrew.gall;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Gallery simpleGallery;
    CustomGalleryAdapter customGalleryAdapter;
    ImageView selectedImageView;
    int count;
    Button btn1;
    int[] images = {R.drawable.w1, R.drawable.w2, R.drawable.w3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.set_immage);
        simpleGallery = findViewById(R.id.simpleGallery); // get the reference of Gallery
        selectedImageView = findViewById(R.id.selectedImageView); // get the reference of ImageView
        customGalleryAdapter = new CustomGalleryAdapter(getApplicationContext(), images); // initialize the adapter
        simpleGallery.setAdapter(customGalleryAdapter); // set the adapter
        simpleGallery.setSpacing(20); //было 10

        simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectedImageView.setImageResource(images[position]);// set the selected image in the ImageView
                count = position;
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int drw = 0;
                switch (count) {
                    case 0:
                        drw = R.drawable.w1;
                        break;
                    case 1:
                        drw = R.drawable.w2;
                        break;
                    case 2:
                        drw = R.drawable.w3;
                        break;
                    case 3:
                        drw = R.drawable.w4;
                        break;
                }
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drw);
                WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    manager.setBitmap(bitmap);

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) //создание менюшки
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.information:
                startActivity(new Intent(this, favourite.class));
        }
        return super.onOptionsItemSelected(item);
    }


    public void favourite(View view) {

    }
}