package v3.projecttech_v3.formularze;


import static v3.projecttech_v3.ConvertStringToBitmap.tmpBitmapsPhotos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import v3.projecttech_v3.AdapertRecyclerView5_Zdjęcie;
import v3.projecttech_v3.BuildConfig;
import v3.projecttech_v3.Maszyna_Activity;
import v3.projecttech_v3.Operator_Activity;
import v3.projecttech_v3.Photo_Activity;
import v3.projecttech_v3.Przewinienie_Activity;
import v3.projecttech_v3.R;
import v3.projecttech_v3.Scanner_Formularz5;


public class Formularz5_Maszyna_Pracownik_Skarga extends AppCompatActivity{

    Intent intent_szukaj_przewinienie;
    Intent intent_dodaj_przewinienie;
    Intent intent_szukaj_maszyna;
    Intent intent_szukaj_operator;
    Intent intent_GoToPhotoActivity;
    String przewinienieBack;
    String maszynaBack;
    String operatorBack;
    String przewinienieBackInput;
    String maszynaBackInput;
    String operatorBackInput;
    String telefonBackInput;
    String SMSBackInput;
    String uwagaBackInput;
    String checkBoxSMSBackInput;
    String barcodeMaszynaInput;
    String telefonOperatorInput;
    RecyclerView recyclerViewImages;
    AdapertRecyclerView5_Zdjęcie adapterRecyclerView;
    public static ArrayList<Bitmap> images;
    public static ArrayList<String> imagesFromPhotoActivity;
    boolean checkboxStatus;


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formularz5_maszyna_magazyn_skarga2);


        EditText inputMaszyna = findViewById(R.id.inputMaszyna);
        EditText inputOperator = findViewById(R.id.inputOperator);
        EditText inputPrzewinienie = findViewById(R.id.inputPrzewinienie);
        EditText inputTelefon = findViewById(R.id.inputTelefon);
        EditText inputSMS = findViewById(R.id.inputSMS);
        EditText inputUwaga = findViewById(R.id.inputUwaga);
        CheckBox checkBoxSMS = findViewById(R.id.checkboxSMS);

        Button buttonDodajPrzewinienie = findViewById(R.id.buttonDodajPrzewinienie);
        Button buttonSzukajPrzewinienie = findViewById(R.id.buttonSzukajPrzewinienie);
        Button buttonSzukajMaszyna = findViewById(R.id.buttonSzukajMaszyna);
        Button buttonSzukajOperator = findViewById(R.id.buttonSzukajOperator);
        Button buttonZdjecie = findViewById(R.id.buttonZdjecie);
        Button buttonScanBarcodeMaszyna = findViewById(R.id.buttonScanBarcodeMaszyna);

        // set edittext with SMS message as inactive on start
        inputSMS.setEnabled(false);


        inputOperator.setEnabled(false);
        inputPrzewinienie.setEnabled(false);
        inputTelefon.setEnabled(false);

        // data/intent from Scanner with scanned barcode
        barcodeMaszynaInput = getIntent().getStringExtra("barcodeInput");
        Log.i("Checking", "barcodeMaszynaInput " + barcodeMaszynaInput);

//        // data/intent from OperatorActivity (telefon)
//        telefonOperatorInput = getIntent().getStringExtra("telefonInput");
//        Log.i("Checking", "telefonOperatorInput " + telefonOperatorInput);
//        inputTelefon.setText(telefonOperatorInput);

        images = new ArrayList<Bitmap>();
//        imagesFromPhotoActivity = new ArrayList<>();
        imagesFromPhotoActivity = null;

        if (tmpBitmapsPhotos != null) {
            images = tmpBitmapsPhotos;
        }


        recyclerViewImages = findViewById(R.id.recyclerViewZdjecia);
        Log.i("Checking", "Images size1 " + Formularz5_Maszyna_Pracownik_Skarga.images.size());
        adapterRecyclerView = new AdapertRecyclerView5_Zdjęcie(this, images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL, false);
        recyclerViewImages.setLayoutManager(gridLayoutManager);
        recyclerViewImages.setAdapter(adapterRecyclerView);


        SharedPreferences preferencesPrzewinienie = getSharedPreferences("preferencesPrzewinienie", MODE_PRIVATE);
        przewinienieBackInput = preferencesPrzewinienie.getString("preferencesPrzewinienie","");

        if (barcodeMaszynaInput == null) {
        SharedPreferences preferencesMaszyna = getSharedPreferences("preferencesMaszyna", MODE_PRIVATE);
        maszynaBackInput = preferencesMaszyna.getString("preferencesMaszyna","");
            inputMaszyna.setText(maszynaBackInput);
        } else {
            inputMaszyna.setText(barcodeMaszynaInput);
        }


        SharedPreferences preferencesOperator = getSharedPreferences("preferencesOperator", MODE_PRIVATE);
        operatorBackInput = preferencesOperator.getString("preferencesOperator","");

        SharedPreferences preferencesTelefon = getSharedPreferences("preferencesTelefon", MODE_PRIVATE);
        telefonBackInput = preferencesTelefon.getString("preferencesTelefon","");

        SharedPreferences preferencesSMS = getSharedPreferences("preferencesSMS", MODE_PRIVATE);
        SMSBackInput = preferencesSMS.getString("preferencesSMS","");

        SharedPreferences preferencesUwaga = getSharedPreferences("preferencesUwaga", MODE_PRIVATE);
        uwagaBackInput = preferencesUwaga.getString("preferencesUwaga","");

        SharedPreferences preferencesCheckBoxSMS = getSharedPreferences("preferencesCheckBoxSMS", MODE_PRIVATE);
        checkBoxSMSBackInput = preferencesCheckBoxSMS.getString("preferencesCheckBoxSMS","0");


        inputPrzewinienie.setText(przewinienieBackInput);

        inputOperator.setText(operatorBackInput);
        inputTelefon.setText(telefonBackInput);
        inputSMS.setText(SMSBackInput);
        inputUwaga.setText(uwagaBackInput);


        if (checkBoxSMSBackInput.equals("1")) {
            checkBoxSMS.setChecked(true);
        } else {
            checkBoxSMS.setChecked(false);
        }

        inputMaszyna.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                inputOperator.setEnabled(true);
                inputTelefon.setEnabled(true);
            }
        });

        inputOperator.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                inputPrzewinienie.setEnabled(true);

            }
        });



        inputSMS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                SharedPreferences preferencesSMS = getSharedPreferences("preferencesSMS", MODE_PRIVATE);
                SharedPreferences.Editor editorSMS = preferencesSMS.edit();
                editorSMS.putString("preferencesSMS", inputSMS.getText().toString());
                editorSMS.apply();
            }
        });

        inputUwaga.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                SharedPreferences preferencesUwaga = getSharedPreferences("preferencesUwaga", MODE_PRIVATE);
                SharedPreferences.Editor editorUwaga = preferencesUwaga.edit();
                editorUwaga.putString("preferencesUwaga", inputUwaga.getText().toString());
                editorUwaga.apply();
            }
        });

        inputTelefon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                SharedPreferences preferencesTelefon = getSharedPreferences("preferencesTelefon", MODE_PRIVATE);
                SharedPreferences.Editor editorTelefon = preferencesTelefon.edit();
                editorTelefon.putString("preferencesTelefon", inputTelefon.getText().toString());
                editorTelefon.apply();
            }
        });


        buttonZdjecie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_GoToPhotoActivity = new Intent(Formularz5_Maszyna_Pracownik_Skarga.this, Photo_Activity.class);
                startActivity(intent_GoToPhotoActivity);
            }
        });


        checkBoxSMS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    inputSMS.setEnabled(true);
                    SharedPreferences preferencesCheckBoxSMS = getSharedPreferences("preferencesCheckBoxSMS", MODE_PRIVATE);
                    SharedPreferences.Editor editorCheckBoxSMS = preferencesCheckBoxSMS.edit();
                    editorCheckBoxSMS.putString("preferencesCheckBoxSMS", "1");
                    editorCheckBoxSMS.apply();
                } else {
                    inputSMS.setEnabled(false);
                }
            }
        });


//        buttonDodajPrzewinienie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent_dodaj_przewinienie = new Intent(Formularz5_Maszyna_Pracownik_Skarga.this, Przewinienie_Activity.class);
//                startActivity(intent_dodaj_przewinienie);
//            }
//        });

        buttonSzukajPrzewinienie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_szukaj_przewinienie = new Intent(Formularz5_Maszyna_Pracownik_Skarga.this, Przewinienie_Activity.class);
                intent_szukaj_przewinienie.putExtra("przewinienieFormularz", inputPrzewinienie.getText().toString());
                Log.i("checking", "intent_szukaj_przewinienie putExtra: " + inputPrzewinienie.getText().toString());


                startActivity(intent_szukaj_przewinienie);
            }
        });

        buttonSzukajMaszyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_szukaj_maszyna = new Intent(Formularz5_Maszyna_Pracownik_Skarga.this, Maszyna_Activity.class);
                intent_szukaj_maszyna.putExtra("maszynaFormularz", inputMaszyna.getText().toString());
                Log.i("checking", "intent_szukaj_maszyna putExtra: " + inputMaszyna.getText().toString());

                startActivity(intent_szukaj_maszyna);
            }
        });

        buttonSzukajOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_szukaj_operator = new Intent(Formularz5_Maszyna_Pracownik_Skarga.this, Operator_Activity.class);
                intent_szukaj_operator.putExtra("operatorFormularz", inputOperator.getText().toString());
                Log.i("checking", "intent_szukaj_operator putExtra: " + inputOperator.getText().toString());


                startActivity(intent_szukaj_operator);
            }
        });

        buttonScanBarcodeMaszyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToScanner = new Intent(Formularz5_Maszyna_Pracownik_Skarga.this, Scanner_Formularz5.class);
                startActivity(intentGoToScanner);
            }
        });


    }

    public Bitmap StringToBitMap(String imageString){
        try{
            byte [] encodeByte=Base64.decode(imageString, Base64.DEFAULT);

            InputStream inputStream  = new ByteArrayInputStream(encodeByte);
            Bitmap bitmapImage  = BitmapFactory.decodeStream(inputStream);
            return bitmapImage;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    public String BitMapToString(Bitmap imageBitmap){
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArrayImage = byteArrayOutputStream .toByteArray();
            String encodedByteArrayImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
//                        Log.i("Checking", "encodedByteArrayImage: " + encodedByteArrayImage.toString());

            return encodedByteArrayImage;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}



//    ExpandableListView expandableListView1;
//    ExpandableListView expandableListView2;
//    ExpandableListView expandableListView3;
//    ExpandableListView expandableListView4;
//    ExpandableListAdapter expandableListAdapter1;
//    ExpandableListAdapter expandableListAdapter2;
//    ExpandableListAdapter expandableListAdapter3;
//    ExpandableListAdapter expandableListAdapter4;
//    List<String> expandableTitleList1;
//    List<String> expandableTitleList2;
//    List<String> expandableTitleList3;
//    List<String> expandableTitleList4;
//    HashMap<String, List<String>> expandableDetailList1;
//    HashMap<String, List<String>> expandableDetailList2;
//    HashMap<String, List<String>> expandableDetailList3;
//    HashMap<String, List<String>> expandableDetailList4;
//
//        TextView textViewMaszyna = findViewById(R.id.textViewMaszyna);
//        TextView textViewOperator = findViewById(R.id.textViewOperator);
//        TextView textViewZmiana = findViewById(R.id.textViewGodzinyZmiana);
//        TextView textViewTelefon = findViewById(R.id.textViewTelefon);
//        TextView textViewKomentarz = findViewById(R.id.textViewKomentarz);
//        Button buttonZdjecie = findViewById(R.id.buttonZdjecie);
//        Button buttonWyslij = findViewById(R.id.buttonWyslij);
//
//        expandableListView1 = (ExpandableListView) findViewById(R.id.expandableListView1);
//        expandableListView2 = (ExpandableListView) findViewById(R.id.expandableListView2);
//        expandableListView3 = (ExpandableListView) findViewById(R.id.expandableListView3);
//        expandableListView4 = (ExpandableListView) findViewById(R.id.expandableListView4);
//
//
//        expandableDetailList1 = ExpandableListDataItems.getData1();
//        expandableDetailList2 = ExpandableListDataItems.getData2();
//        expandableDetailList3 = ExpandableListDataItems.getData3();
//        expandableDetailList4 = ExpandableListDataItems.getData4();
//        expandableTitleList1 = new ArrayList<String>(expandableDetailList1.keySet());
//        expandableTitleList2 = new ArrayList<String>(expandableDetailList2.keySet());
//        expandableTitleList3 = new ArrayList<String>(expandableDetailList3.keySet());
//        expandableTitleList4 = new ArrayList<String>(expandableDetailList4.keySet());
//
//        expandableListAdapter1 = new CustomizedExpandableListAdapter(this, expandableTitleList1, expandableDetailList1);
//        expandableListView1.setAdapter(expandableListAdapter1);
//
//        expandableListAdapter2 = new CustomizedExpandableListAdapter(this, expandableTitleList2, expandableDetailList2);
//        expandableListView2.setAdapter(expandableListAdapter2);
//
//        expandableListAdapter3 = new CustomizedExpandableListAdapter(this, expandableTitleList3, expandableDetailList3);
//        expandableListView3.setAdapter(expandableListAdapter3);
//
//        expandableListAdapter4 = new CustomizedExpandableListAdapter(this, expandableTitleList4, expandableDetailList4);
//        expandableListView4.setAdapter(expandableListAdapter4);
//
//        // This method is called when the group is expanded
//        expandableListView1.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList1.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView2.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList2.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView3.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList3.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView4.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList4.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//
//
//        // This method is called when the group is collapsed
//        expandableListView1.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList1.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView2.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList2.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView3.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList3.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView4.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList4.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // This method is called when the child in any group is clicked
//        // via a toast method, it is shown to display the selected child item as a sample
//        expandableListView1.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//
//                textViewMaszyna.setText(expandableDetailList1.get(
//                        expandableTitleList1.get(groupPosition)).get(
//                        childPosition));
//
//                for (int i = 0; i < expandableListAdapter1.getGroupCount(); i++) {
//                        expandableListView1.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView2.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                textViewZmiana.setText(expandableDetailList2.get(
//                        expandableTitleList2.get(groupPosition)).get(
//                        childPosition));
//
//                for (int i = 0; i < expandableListAdapter2.getGroupCount(); i++) {
//                    expandableListView2.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView3.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                textViewOperator.setText(expandableDetailList3.get(
//                        expandableTitleList3.get(groupPosition)).get(
//                        childPosition));
//
//                textViewTelefon.setText("0000000000");
//
//                for (int i = 0; i < expandableListAdapter3.getGroupCount(); i++) {
//                    expandableListView3.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView4.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                textViewKomentarz.setText(expandableDetailList4.get(
//                        expandableTitleList4.get(groupPosition)).get(
//                        childPosition));
//
//                for (int i = 0; i < expandableListAdapter4.getGroupCount(); i++) {
//                    expandableListView4.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        buttonZdjecie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentZdjecie = new Intent(getApplicationContext(), Photo_Activity.class);
//                startActivity(intentZdjecie);
//            }
//        });
//
//        buttonWyslij.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });