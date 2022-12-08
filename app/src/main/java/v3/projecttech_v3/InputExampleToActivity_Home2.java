package v3.projecttech_v3;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class InputExampleToActivity_Home2 {

    public static ArrayList<ArrayList<String>> zadania_group;
    public static ArrayList<ArrayList<String>> zdanie_produkcji_group;
    public static ArrayList<ArrayList<String>> lokalizacja_group;
    public static ArrayList<ArrayList<String>> przesuniecie_group;

    public static ArrayList<String> tmp_zadania_group1;
    public static ArrayList<String> tmp_zadania_group2;
    public static ArrayList<String> tmp_zadania_group3;
    public static ArrayList<String> tmp_zdanie_produkcji_group1;
    public static ArrayList<String> tmp_zdanie_produkcji_group2;
    public static ArrayList<String> tmp_zdanie_produkcji_group3;
    public static ArrayList<String> tmp_lokalizacja_group1;
    public static ArrayList<String> tmp_lokalizacja_group2;
    public static ArrayList<String> tmp_lokalizacja_group3;
    public static ArrayList<String> tmp_lokalizacja_group4;
    public static ArrayList<String> tmp_lokalizacja_group5;
    public static ArrayList<String> tmp_przesuniecie_group1;
    public static ArrayList<String> tmp_przesuniecie_group2;

    public static ArrayList<ArrayList<String>> user1_2;
    public static ArrayList<ArrayList<String>> user2_2;
    public static ArrayList<ArrayList<String>> user3_2;
    public static ArrayList<ArrayList<String>> user4_2;

    public static ArrayList<ArrayList<ArrayList<String>>> users2;


    public static void inputtingExampleData2() {

        zadania_group = new ArrayList<ArrayList<String>>();
        zdanie_produkcji_group = new ArrayList<ArrayList<String>>();
        lokalizacja_group = new ArrayList<ArrayList<String>>();
        przesuniecie_group = new ArrayList<ArrayList<String>>();

        tmp_zadania_group1 = new ArrayList<String>();
        tmp_zadania_group2 = new ArrayList<String>();
        tmp_zadania_group3 = new ArrayList<String>();
        tmp_zdanie_produkcji_group1 = new ArrayList<String>();
        tmp_zdanie_produkcji_group2 = new ArrayList<String>();
        tmp_zdanie_produkcji_group3 = new ArrayList<String>();
        tmp_lokalizacja_group1 = new ArrayList<String>();
        tmp_lokalizacja_group2 = new ArrayList<String>();
        tmp_lokalizacja_group3 = new ArrayList<String>();
        tmp_lokalizacja_group4 = new ArrayList<String>();
        tmp_lokalizacja_group5 = new ArrayList<String>();
        tmp_przesuniecie_group1 = new ArrayList<String>();
        tmp_przesuniecie_group2 = new ArrayList<String>();

        tmp_zadania_group1.add("1.1");
        tmp_zadania_group1.add("Moje zadania");
        tmp_zadania_group1.add("F");
        tmp_zadania_group1.add(String.valueOf(R.drawable.informacja2));
        zadania_group.add(tmp_zadania_group1);

        tmp_zadania_group2.add("1.1");
        tmp_zadania_group2.add("Utwórz zadanie");
        tmp_zadania_group2.add("F");
        tmp_zadania_group2.add(String.valueOf(R.drawable.informacja2));
        zadania_group.add(tmp_zadania_group2);

        tmp_zadania_group3.add("1.1");
        tmp_zadania_group3.add("Historia zadań");
        tmp_zadania_group3.add("F");
        tmp_zadania_group3.add(String.valueOf(R.drawable.informacja2));
        zadania_group.add(tmp_zadania_group3);

        tmp_zdanie_produkcji_group1.add("2.1");
        tmp_zdanie_produkcji_group1.add("Paletowanie");
        tmp_zdanie_produkcji_group1.add("F");
        tmp_zdanie_produkcji_group1.add(String.valueOf(R.drawable.paletowanie));
        zdanie_produkcji_group.add(tmp_zdanie_produkcji_group1);


        tmp_zdanie_produkcji_group2.add("2.1");
        tmp_zdanie_produkcji_group2.add("Wywóz");
        tmp_zdanie_produkcji_group2.add("F");
        tmp_zdanie_produkcji_group2.add(String.valueOf(R.drawable.wywoz));
        zdanie_produkcji_group.add(tmp_zdanie_produkcji_group2);


        tmp_zdanie_produkcji_group3.add("2.1");
        tmp_zdanie_produkcji_group3.add("Zwrot");
        tmp_zdanie_produkcji_group3.add("F");
        tmp_zdanie_produkcji_group3.add(String.valueOf(R.drawable.zwrot));
        zdanie_produkcji_group.add(tmp_zdanie_produkcji_group3);



        tmp_lokalizacja_group1.add("3.1");
        tmp_lokalizacja_group1.add("Informacja o pozycji");
        tmp_lokalizacja_group1.add("F");
        tmp_lokalizacja_group1.add(String.valueOf(R.drawable.informacja2));
        lokalizacja_group.add(tmp_lokalizacja_group1);


        tmp_lokalizacja_group2.add("3.2");
        tmp_lokalizacja_group2.add("Pozycja lokalizacje");
        tmp_lokalizacja_group2.add("F");
        tmp_lokalizacja_group2.add(String.valueOf(R.drawable.lokalizacja_pozycji));
        lokalizacja_group.add(tmp_lokalizacja_group2);


        tmp_lokalizacja_group3.add("3.3");
        tmp_lokalizacja_group3.add("Lokalizacja zawartość");
        tmp_lokalizacja_group3.add("F");
        tmp_lokalizacja_group3.add(String.valueOf(R.drawable.zawartosc_lokalizacji));
        lokalizacja_group.add(tmp_lokalizacja_group3);



        tmp_lokalizacja_group4.add("3.4");
        tmp_lokalizacja_group4.add("LKO lokalizacja pozycji");
        tmp_lokalizacja_group4.add("F");
        tmp_lokalizacja_group4.add(String.valueOf(R.drawable.lokalizacja_pozycji_lko));
        lokalizacja_group.add(tmp_lokalizacja_group4);



        tmp_lokalizacja_group5.add("3.5");
        tmp_lokalizacja_group5.add("Przesunięcia");
        tmp_lokalizacja_group5.add("G");
        tmp_lokalizacja_group5.add(String.valueOf(R.drawable.informacja2));
        lokalizacja_group.add(tmp_lokalizacja_group5);



        tmp_przesuniecie_group1.add("3.5.1");
        tmp_przesuniecie_group1.add("Pobranie z lokalizacji");
        tmp_przesuniecie_group1.add("F");
        tmp_przesuniecie_group1.add(String.valueOf(R.drawable.informacja2));
        przesuniecie_group.add(tmp_przesuniecie_group1);

        tmp_przesuniecie_group2.add("3.5.1");
        tmp_przesuniecie_group2.add("Odłożenie na lokalizację");
        tmp_przesuniecie_group2.add("F");
        tmp_przesuniecie_group2.add(String.valueOf(R.drawable.informacja2));
        przesuniecie_group.add(tmp_przesuniecie_group2);



        user1_2 = new ArrayList<ArrayList<String>>();
        user2_2 = new ArrayList<ArrayList<String>>();
        user3_2 = new ArrayList<ArrayList<String>>();
        user4_2 = new ArrayList<ArrayList<String>>();


//        user1_2.add(zadania_group.get(0));
//        user1_2.add(zadania_group.get(1));
//        user1_2.add(zadania_group.get(2));
//        user1_2.add(zdanie_produkcji_group.get(0));
//        user1_2.add(zdanie_produkcji_group.get(1));
//        user1_2.add(zdanie_produkcji_group.get(2));
//        user1_2.add(lokalizacja_group.get(0));
//        user1_2.add(lokalizacja_group.get(1));
//        user1_2.add(lokalizacja_group.get(2));
//        user1_2.add(lokalizacja_group.get(3));
//        user1_2.add(lokalizacja_group.get(4));

//        user2_2.add(zadania_group.get(0));
//        user2_2.add(zadania_group.get(1));
//        user2_2.add(zadania_group.get(2));
//        user2_2.add(zdanie_produkcji_group.get(0));
//        user2_2.add(zdanie_produkcji_group.get(1));
//        user2_2.add(zdanie_produkcji_group.get(2));
//        user2_2.add(lokalizacja_group.get(0));
//        user2_2.add(lokalizacja_group.get(1));
//        user2_2.add(lokalizacja_group.get(2));
//        user2_2.add(lokalizacja_group.get(3));
//        user2_2.add(lokalizacja_group.get(4));
//
//        user3_2.add(zadania_group);
//        user3_2.add(zdanie_produkcji_group);
//        user3_2.add(lokalizacja_group);
//
//        user4_2.add(zadania_group);
//        user4_2.add(zdanie_produkcji_group);
//        user4_2.add(lokalizacja_group);
    }

    public static void addZadania() {
        user1_2.add(zadania_group.get(0));
        user1_2.add(zadania_group.get(1));
        user1_2.add(zadania_group.get(2));
    }

    public static void addZdanieProdukcji() {
        user1_2.add(zdanie_produkcji_group.get(0));
        user1_2.add(zdanie_produkcji_group.get(1));
        user1_2.add(zdanie_produkcji_group.get(2));
    }

    public static void addLokalizacja() {
        user1_2.add(lokalizacja_group.get(0));
        user1_2.add(lokalizacja_group.get(1));
        user1_2.add(lokalizacja_group.get(2));
        user1_2.add(lokalizacja_group.get(3));
        user1_2.add(lokalizacja_group.get(4));
    }

    public static void addPrzesuniecia() {
        user1_2.add(przesuniecie_group.get(0));
        user1_2.add(przesuniecie_group.get(1));
    }


    public static ArrayList<ArrayList<String>> gettingRandomUser2() {

        users2 = new ArrayList<ArrayList<ArrayList<String>>>();
        users2.add(user1_2);
//        users2.add(user2_2);
//        users2.add(user3_2);
//        users2.add(user4_2);

        Log.i("checking", "users2: " + user1_2.get(0).get(1));
//        Log.i("checking", "users2: " + user2_2.get(0).get(1));
//        Log.i("checking", "users2: " + user3_2.get(0).get(1));
//        Log.i("checking", "users2: " + user4_2.get(0).get(1));
        Log.i("checking", "users2: " + users2.size());

        Log.i("checking", "user1_2: " + users2.get(0).get(0).get(1));
//        Log.i("checking", "user2_2: " + users2.get(1).get(1).get(1));
//        Log.i("checking", "user3_2: " + users2.get(2).get(1).get(1));
//        Log.i("checking", "user4_2: " + users2.get(3).get(1).get(1));;

        Random generator = new Random();
        int randomIndex = generator.nextInt(users2.size());
//        Log.i("checking", "randomIndex2: " + randomIndex);
//        Log.i("checking", "randomUser2: " + users2.get(randomIndex));

//        ArrayList<ArrayList<ArrayList<String>>> userFinal = users2.get(randomIndex);
        ArrayList<ArrayList<String>> userFinal = users2.get(0);
        Log.i("checking", "randomUser2: " + users2.get(0));
        return userFinal;

    }

}
