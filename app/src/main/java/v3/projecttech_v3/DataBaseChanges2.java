package v3.projecttech_v3;

import static v3.projecttech_v3.Procedura_Magazyn_Pozycje_Lokalizacje2.columnsNames2;
import static v3.projecttech_v3.Procedura_Magazyn_Pozycje_Lokalizacje2.numberOfColumns2;

import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;


public class DataBaseChanges2 extends AsyncTask <String, Void, ArrayList<ArrayList<String>>> {

    static ArrayList<ArrayList<String>> ArrayListWithFinalData = new ArrayList<>();
    public static HashMap<String, String> tmpdata2;

    static ArrayList<String> ListWithColumnsNames = new ArrayList<>();
    ArrayList<Integer> ListWithColumnsWidth = new ArrayList<>();
    static ArrayList<Integer> ListWithColumnsAdjust = new ArrayList<>();
    static ArrayList<String > ListWithCellColor = new ArrayList<>();

    @Override
    protected ArrayList<ArrayList<String>> doInBackground(String... strings) {

        Procedura_Pozycja_Informacje2 informacje = new Procedura_Pozycja_Informacje2();
        tmpdata2 = informacje.takingPositionInformation();

        Procedura_Magazyn_Pozycje_Lokalizacje2 procedura = new Procedura_Magazyn_Pozycje_Lokalizacje2();
        ArrayListWithFinalData = procedura.takingLocalizationPosition();
        Log.i("checking", "method_doInBackground " + ArrayListWithFinalData.size());

        return ArrayListWithFinalData;
    }


    public ArrayList<ArrayList<String>> cleaningDatabase(ArrayList<ArrayList<String>> dataIn){
        for (int i = 0; i < dataIn.size(); i++){
            for (int j = 0; j < numberOfColumns2; j++){
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
            for (int i = 0; i < columnsNames2.size(); i++) {
                String tmpOneColumn = (columnsNames2.get(i).split("\\|")[1]);
            Log.i("checking", "ColumnName: " + i + " " + tmpOneColumn);
//            Log.i("checking", "ColumnName: " + i + " " + tmpOneColumn);
                ListWithColumnsNames.add(tmpOneColumn);
            }
        } catch(Exception e){
            Log.i("checking", "exception method ColumnsNames" + e.toString());
        }
        return ListWithColumnsNames;
    }

    public ArrayList<Integer> columnsWidth() {
        try {

            for (int i = 0; i < columnsNames2.size(); i++) {
                String tmpOneColumn = (columnsNames2.get(i).split("\\|")[2]);
//                Log.i("checking", "method-columnsWidth1: " + tmpOneColumn);
                int tmpOneColumnInt = Integer.parseInt(tmpOneColumn);
//                Log.i("checking", "method-columnsWidth1: " + tmpOneColumnInt);

                ListWithColumnsWidth.add(4 * tmpOneColumnInt);
            }
//            Log.i("checking", "parameterColumn2: " + tmpOneColumn);

        } catch (Exception e) {
            Log.i("checking", "exception method-columnsWidth1" + e.toString());
        }
        return ListWithColumnsWidth;
    }

    public ArrayList<Integer> columnsAdjust() {
        int tmpOneColumnInt;

        try {
            for (int i = 0; i < columnsNames2.size(); i++) {
                String tmpOneColumn = (columnsNames2.get(i).split("\\|")[3]);
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
                ListWithColumnsAdjust.add((int) tmpOneColumnInt);
            }
        }
        catch(Exception e) {
            Log.i("checking", "exception method-columnsAdjust1" + e.toString());
        }
        return ListWithColumnsAdjust;
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
                ListWithCellColor.add(tmpOneRow);
            }
        } catch(Exception e){
            Log.i("checking", "exception method-cellsColor1" + e.toString());
        }
        return ListWithCellColor;
    }

//    public void layoutSetOnDataBase(ArrayList<ArrayList<String>> data) {
//        ArrayList<String> tmpColumnsNames = columnsNames(data);
//        for (int i = 0; i < numberOfColumns; i++){
//            data.get(0).set(i, tmpColumnsNames.get(i));
//}
//    }

}

