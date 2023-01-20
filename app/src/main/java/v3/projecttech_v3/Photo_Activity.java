package v3.projecttech_v3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import v3.projecttech_v3.formularze.Formularz5_Maszyna_Pracownik_Skarga;

public class Photo_Activity extends AppCompatActivity {

    ImageView imageViewPhoto;
    Button buttonPhoto;
    Button buttonPhotoZatwierdz;
    public static ArrayList<Bitmap> bitmapsPhotos;
    public static ArrayList<String> bytesPhotos;
    ImageView imageViewMini1;
    ImageView imageViewMini2;
    ImageView imageViewMini3;
    ImageView imageViewMini4;



    public static final int CAMERA_ACTION_CODE = 1;
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    int requestCode = activityResult.getResultCode();
                    Intent data = activityResult.getData();

                    if (requestCode == RESULT_OK && data != null) {
                        Bitmap bitmapPhoto = (Bitmap) data.getExtras().get("data");
                        imageViewPhoto.setImageBitmap(bitmapPhoto);

                        bitmapsPhotos.add(bitmapPhoto);
                        Log.i("Checking", "Bitmaps size " + bitmapsPhotos.size());

                        if (Formularz5_Maszyna_Pracownik_Skarga.images.size() > 0) {
                            imageViewMini1.setImageBitmap(bitmapPhoto);
                        }

                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmapPhoto.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byte[] byteArrayImage = byteArrayOutputStream .toByteArray();
                        String encodedByteArrayImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
                        bytesPhotos.add(encodedByteArrayImage);

                    }
                }
            }
        );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageViewPhoto = findViewById(R.id.imageViewPhoto);
        buttonPhoto = findViewById(R.id.buttonPhoto);
        buttonPhotoZatwierdz = findViewById(R.id.buttonPhotoZatwierdz);
        imageViewMini1 = findViewById(R.id.imageViewMini1);
        imageViewMini2 = findViewById(R.id.imageViewMini2);
        imageViewMini3 = findViewById(R.id.imageViewMini3);
        imageViewMini4 = findViewById(R.id.imageViewMini4);

        bitmapsPhotos = new ArrayList<Bitmap>();

        imageViewMini1.setImageResource(R.drawable.ic_photo_size_select_large_24);
        imageViewMini2.setImageResource(R.drawable.ic_photo_size_select_large_24);
        imageViewMini3.setImageResource(R.drawable.ic_photo_size_select_large_24);
        imageViewMini4.setImageResource(R.drawable.ic_photo_size_select_large_24);


        // Request for camera runtime permission
        if (ContextCompat.checkSelfPermission(Photo_Activity.this, Manifest.permission.CAMERA)
            !=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Photo_Activity.this, new String[] {
                    Manifest.permission.CAMERA
            }, CAMERA_ACTION_CODE);
        }

//        final int[] howManyClicks = {0};

        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (intentMakePhoto.resolveActivity(getPackageManager()) != null) {
//                    startActivityForResult(intentMakePhoto, CAMERA_ACTION_CODE);
                    activityResultLauncher.launch(intentMakePhoto);
//                    howManyClicks[0]++;
                } else {
                    Toast.makeText(Photo_Activity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonPhotoZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToFormularz = new Intent(Photo_Activity.this, Formularz5_Maszyna_Pracownik_Skarga.class);
                intentGoToFormularz.putStringArrayListExtra("imagesByte", bytesPhotos);
                startActivity(intentGoToFormularz);
            }
        });

     }

}