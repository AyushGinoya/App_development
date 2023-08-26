package com.example.lab_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button click,gClick,next;
    Intent intent;

    private final static int REQ_CODE_CAM = 1;
    private final static int REQ_CODE_GAL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.image1);
        click = findViewById(R.id.btn);
        gClick = findViewById(R.id.btngal);
        next = findViewById(R.id.next);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQ_CODE_CAM);
            }
        });

        gClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_PICK);
                //Intent.ACTION_PICK. This action is used to select and return one or multiple data items from a set of data sources
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // represents the URI for the images in the external storage. This URI points to the collection of images stored on the device's external storage
                startActivityForResult(intent, REQ_CODE_GAL);
                // The REQ_CODE_GAL is a request code that you'll later use in the onActivityResult callback to identify which result you're handling.
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, VideoAcitivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            //The RESULT_OK constant typically means that the operation, in this case, capturing an image or selecting an image from the gallery, was completed successfully.
            if (requestCode == REQ_CODE_CAM) {
                //This inner conditional block checks if the requestCode matches the value REQ_CODE_CAM, which indicates that the result is from the camera activity.
                Bitmap m = (Bitmap) data.getExtras().get("data");
                // The "data" key is used to retrieve the thumbnail image.
                img.setImageBitmap(m);
            } else if (requestCode == REQ_CODE_GAL) {
                if (data != null && data.getData() != null) {
                    Uri selectedImageUri = data.getData();
                    img.setImageURI(selectedImageUri);
                }
            }
        }
    }

}
