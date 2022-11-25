package v3.projecttech_v3;

import static v3.projecttech_v3.Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycje.columnsNames4;
import static v3.projecttech_v3.Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycje.numberOfColumns4;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBaseChanges4 extends AsyncTask<String, Void, ArrayList<ArrayList<String>>> {

    static ArrayList<ArrayList<String>> ArrayListWithFinalData4 = new ArrayList<>();

    static ArrayList<String> ListWithColumnsNames4 = new ArrayList<>();
    ArrayList<Integer> ListWithColumnsWidth4 = new ArrayList<>();
    static ArrayList<Integer> ListWithColumnsAdjust4 = new ArrayList<>();
    static ArrayList<String > ListWithCellColor4 = new ArrayList<>();

    @Override
    protected ArrayList<ArrayList<String>> doInBackground(String... strings) {

        Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycje procedura = new Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycje();
        ArrayListWithFinalData4 = procedura.takingInformationAboutLocalisation();
        Log.i("checking", "method_doInBackground " + ArrayListWithFinalData4.size());

        return ArrayListWithFinalData4;
    }

    public ArrayList<ArrayList<String>> cleaningDatabase(ArrayList<ArrayList<String>> dataIn){
        for (int i = 0; i < dataIn.size(); i++){
            for (int j = 0; j < numberOfColumns4; j++){
                if (dataIn.get(i).get(j) == null || dataIn.get(i).get(j).isEmpty()) {
//                    Log.i("checking", "method celaningDatabase: " + i + " " + dataIn.get(i).get(j));
                    dataIn.get(i).set(j,"0");
//                    Log.i("checking", "method celaningDatabase: " + i + " " + dataIn.get(i).get(j));
                }
            }
        }
        return dataIn;
    }

    public ArrayList<String> columnsNames() {

        try {
            for (int i = 0; i < columnsNames4.size(); i++) {
                String tmpOneColumn = (columnsNames4.get(i).split("\\|")[1]);
                Log.i("checking", "ColumnName3: " + i + " " + tmpOneColumn);

                ListWithColumnsNames4.add(tmpOneColumn);

            }
        } catch(Exception e){
            Log.i("checking", "exception method ColumnsNames" + e.toString());
        }
        return ListWithColumnsNames4;
    }

    public ArrayList<Integer> columnsWidth() {
        try {

            for (int i = 0; i < columnsNames4.size(); i++) {
                String tmpOneColumn = (columnsNames4.get(i).split("\\|")[2]);
//                Log.i("checking", "method-columnsWidth1: " + tmpOneColumn);
                int tmpOneColumnInt = Integer.parseInt(tmpOneColumn);
//                Log.i("checking", "method-columnsWidth1: " + tmpOneColumnInt);

                ListWithColumnsWidth4.add(4 * tmpOneColumnInt);
            }
//            Log.i("checking", "parameterColumn2: " + tmpOneColumn);

        } catch (Exception e) {
            Log.i("checking", "exception method-columnsWidth1" + e.toString());
        }
        return ListWithColumnsWidth4;
    }

    public ArrayList<Integer> columnsAdjust() {
        int tmpOneColumnInt;

        try {
            for (int i = 0; i < columnsNames4.size(); i++) {
                String tmpOneColumn = (columnsNames4.get(i).split("\\|")[3]);
//                Log.i("checking", "method-columnsAdjust1: " + tmpOneColumn);

                switch (tmpOneColumn) {
                    case "2":
                        tmpOneColumnInt = 17; //CENTER
                        break;
                    case "0":
                        tmpOneColumnInt = 3; //LEFT
                        break;
                    case "1":
                        tmpOneColumnInt = 5; //RIGHT
                        break;
                    default:
                        tmpOneColumnInt = 0; //NO GRAVITY - NO ALIGNMENT
                }
//                Log.i("checking", "method-columnsAdjust2: " + tmpOneColumnInt);
                ListWithColumnsAdjust4.add((int) tmpOneColumnInt);
            }
        }
        catch(Exception e) {
            Log.i("checking", "exception method-columnsAdjust1" + e.toString());
        }
        return ListWithColumnsAdjust4;
    }

    public ArrayList<String> cellsColor(ArrayList<ArrayList<String>> records) {
        try {
            int numberOfRows = records.size();
            for (int i = 0; i < numberOfRows; i++) {
                String[] tmpOneRowTable = records.get(i).get(0).toString().split(",");
                String tmpOneRow = tmpOneRowTable[0] + "," + tmpOneRowTable[1] + "," + tmpOneRowTable[2];
//                Log.i("checking", "method-cellsColor1: " + i + " " + tmpOneRow);
                switch (tmpOneRow) {
                    case "255,255,255":
                        tmpOneRow = "#FFC9BB"; //color RED
                        break;
                    case "255,000,000":
                        tmpOneRow = "#F5F5F5"; //color GREY
                        break;
                    case "000,000,000":
                        tmpOneRow = "#FFFFFFFF"; //color WHITE
                        break;
                    default:
                        tmpOneRow = "#FFFFFFFF"; //color WHITE
                }

//                Log.i("checking", "method-cellsColor2: " + tmpOneRow);
                ListWithCellColor4.add(tmpOneRow);
            }
        } catch(Exception e){
            Log.i("checking", "exception method-cellsColor1" + e.toString());
        }
        return ListWithCellColor4;
    }

}

