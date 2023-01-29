package v3.projecttech_v3;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import v3.projecttech_v3.R;

public class InputExampleToActivity_Home {

    public static ArrayList<String> zadania;
    public static ArrayList<String> zdanie_produkcji;
    public static ArrayList<String> lokalizacja;
    public static ArrayList<String> zarzadzanie_odpadami;
    public static ArrayList<String> ustawienia;
    public static ArrayList<String> pobranie_materialu;
    public static ArrayList<String> pobranie_zlokalizacji;
    public static ArrayList<String> odlozenie_nalokalizacje;

    public static ArrayList<ArrayList<String>> user1_1;
    public static ArrayList<ArrayList<String>> user2_1;
    public static ArrayList<ArrayList<String>> user3_1;
    public static ArrayList<ArrayList<String>> user4_1;

    public static ArrayList<ArrayList<ArrayList<String>>> users1;


    public static void inputtingExampleData() {

        zadania = new ArrayList<String>();
        zdanie_produkcji = new ArrayList<String>();
        lokalizacja = new ArrayList<String>();
        zarzadzanie_odpadami = new ArrayList<String>();
        ustawienia = new ArrayList<String>();
        pobranie_materialu = new ArrayList<String>();
        pobranie_zlokalizacji = new ArrayList<String>();
        odlozenie_nalokalizacje = new ArrayList<String>();


        zadania.add("1");
        zadania.add("Zadania");
        zadania.add("G");
        zadania.add(String.valueOf(R.drawable.informacja2));
//        Log.i("checking", "zadania: " + zadania.size());
//        Log.i("checking", "zadania: " + zadania.get(1));

        zdanie_produkcji.add("2");
        zdanie_produkcji.add("Zdanie produkcji");
        zdanie_produkcji.add("G");
        zdanie_produkcji.add(String.valueOf(R.drawable.paletazpaczkami));

        lokalizacja.add("3");
        lokalizacja.add("Lokalizacja");
        lokalizacja.add("G");
        lokalizacja.add(String.valueOf(R.drawable.informacja2));

        zarzadzanie_odpadami.add("4");
        zarzadzanie_odpadami.add("Zarządzanie odpadami");
        zarzadzanie_odpadami.add("G");
        zarzadzanie_odpadami.add(String.valueOf(R.drawable.recycling));

        ustawienia.add("5");
        ustawienia.add("Ustawienia");
        ustawienia.add("F");
        ustawienia.add(String.valueOf(R.drawable.ustawienia));

        pobranie_materialu.add("6");
        pobranie_materialu.add("Pobieranie materiału");
        pobranie_materialu.add("F");
        pobranie_materialu.add(String.valueOf(R.drawable.informacja2));

        pobranie_zlokalizacji.add("7");
        pobranie_zlokalizacji.add("Pobranie lokalizacji");
        pobranie_zlokalizacji.add("F");
        pobranie_zlokalizacji.add(String.valueOf(R.drawable.informacja2));

        odlozenie_nalokalizacje.add("8");
        odlozenie_nalokalizacje.add("Odłożenie na lokalizację");
        odlozenie_nalokalizacje.add("F");
        odlozenie_nalokalizacje.add(String.valueOf(R.drawable.informacja2));

        user1_1 = new ArrayList<>();
        user2_1 = new ArrayList<>();
        user3_1 = new ArrayList<>();
        user4_1 = new ArrayList<>();

        user1_1.add(zadania);
        user1_1.add(zdanie_produkcji);
        user1_1.add(lokalizacja);
        user1_1.add(zarzadzanie_odpadami);
        user1_1.add(ustawienia);
        user1_1.add(pobranie_materialu);
        user1_1.add(pobranie_zlokalizacji);
        user1_1.add(odlozenie_nalokalizacje);


        user2_1.add(zadania);
        user2_1.add(zdanie_produkcji);
        user2_1.add(lokalizacja);
        user2_1.add(zarzadzanie_odpadami);
        user2_1.add(ustawienia);


        user3_1.add(lokalizacja);
        user3_1.add(zarzadzanie_odpadami);
        user3_1.add(ustawienia);


        user4_1.add(lokalizacja);


    }

    public static ArrayList<ArrayList<String>> gettingRandomUser1() {

        users1 = new ArrayList<ArrayList<ArrayList<String>>>();
        users1.add(user1_1);
        users1.add(user2_1);
        users1.add(user3_1);
        users1.add(user4_1);

//        Log.i("checking", "users: " + users1.size());
//        Log.i("checking", "user1: " + users1.get(0).get(0).toString());
//        Log.i("checking", "user2: " + users1.get(1).get(0).toString());
//        Log.i("checking", "user3: " + users1.get(2).get(0).toString());
//        Log.i("checking", "user4: " + users1.get(3).get(0).toString());

        Random generator = new Random();
        int randomIndex = generator.nextInt(users1.size());
//        Log.i("checking", "randomIndex: " + randomIndex);
//        Log.i("checking", "randomUser: " + users1.get(randomIndex));

//        ArrayList<ArrayList<String>> userFinal = users1.get(randomIndex);
        ArrayList<ArrayList<String>> userFinal = users1.get(0);
        return userFinal;

        }
    }
