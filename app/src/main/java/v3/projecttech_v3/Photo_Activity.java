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
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Photo_Activity extends AppCompatActivity {

    ImageView imageViewPhoto;
    Button buttonPhoto;
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

        // Request for camera runtime permission
        if (ContextCompat.checkSelfPermission(Photo_Activity.this, Manifest.permission.CAMERA)
            !=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Photo_Activity.this, new String[] {
                    Manifest.permission.CAMERA
            }, CAMERA_ACTION_CODE);
        }

        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intentMakePhoto.resolveActivity(getPackageManager()) != null) {
//                    startActivityForResult(intentMakePhoto, CAMERA_ACTION_CODE);
                    activityResultLauncher.launch(intentMakePhoto);
                } else {
                    Toast.makeText(Photo_Activity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
                }
            }
        });
     }

//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//            if (requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null) {
//                Bitmap bitmapPhoto = (Bitmap) data.getExtras().get("data");
//                imageViewPhoto.setImageBitmap(bitmapPhoto);
//            }
//        }


}