package v3.projecttech_v3;

import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.rKomunikat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.sourceforge.jtds.jdbc.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;

import v3.projecttech_v3.db.DataBaseHelper5;
import v3.projecttech_v3.db.entity.Data4;
import v3.projecttech_v3.db.entity.Data5;

public class Activity_Register extends AppCompatActivity {
    TextView inputImie;
    TextView inputNazwisko;
    TextView inputEmail;
    TextView inputTelefon;
    TextView inputLokalizacja;
    TextView inputDzial;
    TextView inputStanowisko;
    TextView inputHaslo;
    TextView inputHasloPotwierdz;
    TextView textViewRejestracja;
    TextView textViewMaszJuzKonto;
    public static DataBaseHelper5 dataBaseSQLUser;
    public static Data5 tmpInsertData;
    public static String tmpstatusID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputImie = findViewById(R.id.inputImie);
        inputNazwisko = findViewById(R.id.inputNazwisko);
        inputEmail = findViewById(R.id.inputEmail);
        inputTelefon = findViewById(R.id.inputTelefon);
        inputLokalizacja = findViewById(R.id.inputLokalizacja);
        inputDzial = findViewById(R.id.inputDzial);
        inputStanowisko = findViewById(R.id.inputStanowisko);
        inputHaslo = findViewById(R.id.inputHaslo);
        inputHasloPotwierdz = findViewById(R.id.inputHasloPotwierdz);
        textViewRejestracja = findViewById(R.id.textViewRejestracja);
        textViewMaszJuzKonto = findViewById(R.id.textViewMaszJuzKonto);

        ImageView imageLogo2 = findViewById(R.id.imageLogo2);
        Button buttonRejestracja = findViewById(R.id.buttonRejestracja);


        dataBaseSQLUser = new DataBaseHelper5(Activity_Register.this);

        Boolean isAllFieldsChecked = CheckAllFields();

        buttonRejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckAllFields()) {
                    Intent intentRegister = new Intent(Activity_Register.this, Activity_Login.class);
                    dataBaseSQLUser.deleteAllData();
                    takingValuesFromInputTextView();
                    dataBaseSQLUser.insertData(tmpInsertData);
                    Data5 a = dataBaseSQLUser.getAllData().get(0);
                    Toast toast_register1 = Toast.makeText(getApplicationContext(), "Rejestracja przebiegła pomyślnie", Toast.LENGTH_LONG);
                    startActivity(intentRegister);
                } else {
                    Toast toast_register2 = Toast.makeText(getApplicationContext(), "Wprowadzone dane są niepoprawne", Toast.LENGTH_LONG);
                }
            }
        });

        textViewMaszJuzKonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMamJuzKonto = new Intent(Activity_Register.this, Activity_Login.class);
                startActivity(intentMamJuzKonto);
            }
        });

        String insertDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            insertDate = LocalDateTime.now().toString();
        }
    }



// taking values from input textviews
    public Data5 takingValuesFromInputTextView() {
            String imie = inputImie.getText().toString();
            String nazwisko = inputNazwisko.getText().toString();
            String email = inputEmail.getText().toString();
            String telefon = inputTelefon.getText().toString();
            String lokalizacja = inputLokalizacja.getText().toString();
            String dzial = inputDzial.getText().toString();
            String stanowisko = inputStanowisko.getText().toString();
            String haslo = inputHasloPotwierdz.getText().toString();
            tmpstatusID = "1";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tmpInsertData = new Data5(
                inputImie.getText().toString(),
                inputNazwisko.getText().toString(),
                inputEmail.getText().toString(),
                inputTelefon.getText().toString(),
                inputLokalizacja.getText().toString(),
                inputDzial.getText().toString(),
                stanowisko = inputStanowisko.getText().toString(),
                LocalDateTime.now().toString(),             // addDate
                tmpstatusID,                 // statusID
                inputHasloPotwierdz.getText().toString()
            );
        }
        return tmpInsertData;
    }


    // validation of inputs
    String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
    String checkPassword = "^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            //"(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=S+$)" +           //no white spaces
            ".{4,}" +               //at least 4 characters
            "$";

    private boolean CheckAllFields() {
        if (validateImie()) {
        return true;
        }
        if (validateNazwisko()) {
            return true;
        }
        if (inputEmail()) {
            return true;
        }
        if (inputTelefon()) {
            return true;
        }
        if (inputLokalizacja()) {
            return true;
        }
        if (inputDzial()) {
            return true;
        }
        if (inputStanowisko()) {
            return true;
        }
        if (inputHaslo()) {
            return true;
        }
        if (inputHasloPotwierdz()) {
            return true;
        }
        // after all validation return true.
        return true;
        }

        public boolean validateImie() {
            if (inputImie.length() == 0) {
                inputImie.setError("This field is required");
        }
            return false;}

        public boolean validateNazwisko() {
            if (inputNazwisko.length() == 0) {
                inputNazwisko.setError("This field is required");
            }
            return false;}

        public boolean inputEmail() {
            if (inputEmail.length() == 0) {
                inputEmail.setError("This field is required");
                return false;
            } else if (!inputEmail.toString().matches(checkEmail)) {
                inputNazwisko.setError("Email is incorrect");
            }
            return false;}

        public boolean inputTelefon() {
            if (inputTelefon.length() == 0) {
                inputTelefon.setError("This field is required");
            }
        return false;}

        public boolean inputLokalizacja() {
            if (inputLokalizacja.length() == 0) {
                inputLokalizacja.setError("This field is required");
            }
            return false;}

        public boolean inputDzial() {
            if (inputDzial.length() == 0) {
                inputDzial.setError("This field is required");
            }
            return false;}

        public boolean inputStanowisko() {
            if (inputStanowisko.length() == 0) {
                inputStanowisko.setError("This field is required");
            }
            return false;}

        public boolean inputHaslo() {
            if (inputHaslo.length() == 0) {
                inputHaslo.setError("Password is required");
            return false;
            } else if (inputHaslo.toString().matches(checkPassword)) {
            inputHaslo.setError("Password should contain minimum 4 characters");
                return false;
            }
            return true;
            }

        public boolean inputHasloPotwierdz() {
            if (inputHasloPotwierdz.length() == 0) {
                inputHasloPotwierdz.setError("Password is required");
                return false;
            } else if (inputHaslo.toString().matches(checkPassword)) {
                inputHaslo.setError("Password should contain minimum 4 characters");
                return false;
            } else if (inputHasloPotwierdz.equals(inputHaslo)) {
                inputHasloPotwierdz.setError("Check password, must be the same");
                return false;
            }
            return true;
        }

}