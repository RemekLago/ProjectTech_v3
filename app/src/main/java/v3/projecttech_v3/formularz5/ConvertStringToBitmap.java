package v3.projecttech_v3.formularz5;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.android.material.internal.ViewOverlayImpl;

import java.util.ArrayList;


public class ConvertStringToBitmap extends Thread {

    public static ArrayList<Bitmap> tmpBitmapsPhotos;


    public static void converting(Bitmap bitmap) {

        tmpBitmapsPhotos.add(bitmap);
        Log.i("Checking", "tmpBitmapsPhotos size: " + tmpBitmapsPhotos.size());

    }




//    @Override
//    public void run() {
//        for (int i = 0; i < imagesFromPhotoActivity.size(); i++) {
//            Bitmap decodedImage = StringToBitMap(imagesFromPhotoActivity.get(i));
//            Log.i("Checking", "Images adding " + imagesFromPhotoActivity.get(i));
//            Formularz5_Maszyna_Pracownik_Skarga.images.add(decodedImage);
//        }
//    }
//
//    public Bitmap StringToBitMap(String imageString){
//        try{
//            byte [] encodeByte= Base64.decode(imageString, Base64.DEFAULT);
//
//            InputStream inputStream  = new ByteArrayInputStream(encodeByte);
//            Bitmap bitmapImage  = BitmapFactory.decodeStream(inputStream);
//            return bitmapImage;
//        }catch(Exception e){
//            e.getMessage();
//            return null;
//        }
//    }
}
