package v3.projecttech_v3;

import static v3.projecttech_v3.Activity_Home_Main.dataBaseSQLHome;
import static v3.projecttech_v3.Activity_Home_Main.listWithUserSettings;
import static v3.projecttech_v3.Activity_Home_Main.preferences;
import static v3.projecttech_v3.Activity_Home_Main.userAccessLevel;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import v3.projecttech_v3.Formularze.Formularz1_InformacjeOPozycji_MainActivity_Table2;
import v3.projecttech_v3.Formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja;

public class AdapterRecyclerView_Home extends RecyclerView.Adapter<AdapterRecyclerView_Home.ViewHolder> {

    ArrayList<String> tmpTitles;
//    ArrayList<Drawable> tmpImages;
    ArrayList<Bitmap> tmpImages;
    LayoutInflater inflater;
    public static ArrayList<ArrayList<String>> tmpUserSettings2;


    public AdapterRecyclerView_Home(Context context, ArrayList<String> tmpTitles, ArrayList<Bitmap> tmpImages) {
        this.tmpTitles = tmpTitles;
        this.tmpImages = tmpImages;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(tmpTitles.get(position));
        holder.gridIcon.setImageBitmap(tmpImages.get(position));
//        holder.gridIcon.setImageDrawable(tmpImages.get(position));

    }

    @Override
    public int getItemCount() {
        return tmpImages.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView gridIcon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView_cardview1);
            gridIcon = itemView.findViewById(R.id.image_cardview1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    String clickedTitle = title.getText().toString();
                    Log.i("checking", clickedTitle);
                    int tmpNodeId = 0;
                    int groupType = 0;
                    Log.i("checking", "tmpNodeId_1: " + tmpNodeId);

                    int sizeOfDataInDatabase = dataBaseSQLHome.getAllData().size();

                    for (int i=0; i < sizeOfDataInDatabase; i++ ) {
                        if (clickedTitle.equals(dataBaseSQLHome.getAllData().get(i).getName())) {
                            Log.i("checking", "clickedTitlefromDatabase: " + dataBaseSQLHome.getAllData().get(i).getName());
                            Log.i("checking", "clickedTitlefromDatabase: " + dataBaseSQLHome.getAllData().get(i).getParentId());
                            Log.i("checking", "clickedTitlefromDatabase: " + dataBaseSQLHome.getAllData().get(i).getChildId());
                            tmpNodeId = Integer.parseInt(dataBaseSQLHome.getAllData().get(i).getChildId());
                            Log.i("checking", "tmpNodeId_2: " + tmpNodeId);
                            if (dataBaseSQLHome.getAllData().get(i).getType().equals("G")) {
                                groupType = 1;              // 1 odpowiada G
                            } else {
                                groupType = 0;              // 0 odpowiada F
                            }
                        }
                    }

                    SharedPreferences.Editor editor3 = preferences.edit();
                    editor3.putInt("UserSettings", tmpNodeId);
                    editor3.apply();
                    userAccessLevel = preferences.getInt("UserSettings",-1);
                    Log.i("checking", "userAccessLevel_Procedura: " + userAccessLevel);

//                    if (groupType == 0) {
                        if (groupType == 1) { //for testing set 1

//                        Intent goToFormularz = new Intent(v.getContext(), Activity_Home_Main.class);
//                        v.getContext().startActivity(goToFormularz);
                        switch (clickedTitle) {
                            case "Informacje o pozycji":
//                                Intent goToInformacjeOPozycji = new Intent(v.getContext(), Formularz1_InformacjeOPozycji_MainActivity_Table2.class);
//                                v.getContext().startActivity(goToInformacjeOPozycji);
                                break;

                            case "Pozycja lokalizacje":
//                                Intent goToPozycjaLokalizacje = new Intent(v.getContext(), Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.class);
//                                v.getContext().startActivity(goToPozycjaLokalizacje);
                                break;

                            case "Lokalizacja":
                                Intent goToPozycjaLokalizacje = new Intent(v.getContext(), Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.class);
                                v.getContext().startActivity(goToPozycjaLokalizacje);
//                                Intent goToInformacjeOPozycji = new Intent(v.getContext(), Formularz1_InformacjeOPozycji_MainActivity_Table2.class);
//                                v.getContext().startActivity(goToInformacjeOPozycji);

                                break;

                            default:
                                Toast.makeText(v.getContext(), "Formularz ", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Intent goToHome =new Intent(v.getContext(), Activity_Home_Main.class);
                        v.getContext().startActivity(goToHome);
                    }

//                    tmpUserSettings2 = new ArrayList<ArrayList<String>>();
//                    inputtingExampleData2();
//                    int clickedId;
//                    // only for tests
//                    Intent intentFormularz = new Intent(v.getContext(), MainActivity_enterdata.class);

//                    switch (title.getText().toString()) {
//                        case "Zadania":
//                            int a1 = 1; // only for tests
//                            addZadania();
//                            tmpUserSettings2 = gettingRandomUser2();
//                            Intent intentGoToZadania = new Intent(v.getContext(), Activity_Home_Main.class);
//                            v.getContext().startActivity(intentGoToZadania);
//                            break;
//
//                        case "Zdanie produkcji":
//                            int a2 = 2; // only for tests
//                            addZdanieProdukcji();
//                            tmpUserSettings2 = gettingRandomUser2();
//                            Intent intentGoToZdanieProdukcji = new Intent(v.getContext(), Activity_Home_Main.class);
//                            v.getContext().startActivity(intentGoToZdanieProdukcji);
//                            break;
//
//                        case "Lokalizacja":
//                            addLokalizacja();
//                            tmpUserSettings2 = gettingRandomUser2();
//                            int a3 = 3; // only for tests
//                            Intent intentGoToLokalizacja = new Intent(v.getContext(), Activity_Home_Main.class);
//                            v.getContext().startActivity(intentGoToLokalizacja);
//                            break;
//
//                        case "Zarzadzanie odpadami":
//                            v.getContext().startActivity(intentFormularz);
//                            break;
//
//                        case "Ustawienia":
//                            v.getContext().startActivity(intentFormularz);
//
//
//                        case "Pobranie materialu":
//                            v.getContext().startActivity(intentFormularz);
//                            break;
//
//
//                        case "Przesunięcia":
//                            user1_2.clear();
//                            addPrzesuniecia();
//                            tmpUserSettings2 = gettingRandomUser2();
//                            int a4 = 4; // only for tests
//                            Intent intentGoToPrzesuniecia = new Intent(v.getContext(), Activity_Home_Main.class);
//                            v.getContext().startActivity(intentGoToPrzesuniecia);
//                            break;
//
//
//                        case "Pobranie z lokalizacji":
//                            v.getContext().startActivity(intentFormularz);
//
//                        case "Odłożenie na lokalizację":
//                            v.getContext().startActivity(intentFormularz);
//
//                        default:

//                    }


//                    Toast.makeText(v.getContext(), "Clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
