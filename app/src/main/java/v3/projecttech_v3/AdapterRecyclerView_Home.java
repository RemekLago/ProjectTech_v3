package v3.projecttech_v3;

import static v3.projecttech_v3.Activity_Home_Main.userSettings2;
import static v3.projecttech_v3.InputExampleToActivity_Home2.addLokalizacja;
import static v3.projecttech_v3.InputExampleToActivity_Home2.addPrzesuniecia;
import static v3.projecttech_v3.InputExampleToActivity_Home2.addZadania;
import static v3.projecttech_v3.InputExampleToActivity_Home2.addZdanieProdukcji;
import static v3.projecttech_v3.InputExampleToActivity_Home2.gettingRandomUser2;
import static v3.projecttech_v3.InputExampleToActivity_Home2.inputtingExampleData2;
import static v3.projecttech_v3.InputExampleToActivity_Home2.user1_2;

import android.content.Context;
import android.content.Intent;
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

public class AdapterRecyclerView_Home extends RecyclerView.Adapter<AdapterRecyclerView_Home.ViewHolder> {

    ArrayList<String> tmpTitles;
    ArrayList<Integer> tmpImages;
    LayoutInflater inflater;
    public static ArrayList<ArrayList<String>> tmpUserSettings2;


    public AdapterRecyclerView_Home(Context context, ArrayList<String> tmpTitles, ArrayList<Integer> tmpImages) {
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
        holder.gridIcon.setImageResource(tmpImages.get(position));

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
                    Log.i("checking", title.getText().toString());
                    tmpUserSettings2 = new ArrayList<ArrayList<String>>();
                    inputtingExampleData2();
                    int clickedId;
                    // only for tests
                    Intent intentFormularz = new Intent(v.getContext(), MainActivity_enterdata.class);


                    switch (title.getText().toString()) {
                        case "Zadania":
                            int a1 = 1; // only for tests
                            addZadania();
                            tmpUserSettings2 = gettingRandomUser2();
                            Intent intentGoToZadania = new Intent(v.getContext(), Activity_Home_Main.class);
                            v.getContext().startActivity(intentGoToZadania);
                            break;

                        case "Zdanie produkcji":
                            int a2 = 2; // only for tests
                            addZdanieProdukcji();
                            tmpUserSettings2 = gettingRandomUser2();
                            Intent intentGoToZdanieProdukcji = new Intent(v.getContext(), Activity_Home_Main.class);
                            v.getContext().startActivity(intentGoToZdanieProdukcji);
                            break;

                        case "Lokalizacja":
                            addLokalizacja();
                            tmpUserSettings2 = gettingRandomUser2();
                            int a3 = 3; // only for tests
                            Intent intentGoToLokalizacja = new Intent(v.getContext(), Activity_Home_Main.class);
                            v.getContext().startActivity(intentGoToLokalizacja);
                            break;

                        case "Zarzadzanie odpadami":
                            v.getContext().startActivity(intentFormularz);
                            break;

                        case "Ustawienia":
                            v.getContext().startActivity(intentFormularz);


                        case "Pobranie materialu":
                            v.getContext().startActivity(intentFormularz);
                            break;


                        case "Przesunięcia":
                            user1_2.clear();
                            addPrzesuniecia();
                            tmpUserSettings2 = gettingRandomUser2();
                            int a4 = 4; // only for tests
                            Intent intentGoToPrzesuniecia = new Intent(v.getContext(), Activity_Home_Main.class);
                            v.getContext().startActivity(intentGoToPrzesuniecia);
                            break;


                        case "Pobranie z lokalizacji":
                            v.getContext().startActivity(intentFormularz);

                        case "Odłożenie na lokalizację":
                            v.getContext().startActivity(intentFormularz);

                        default:

                    }


                    Toast.makeText(v.getContext(), "Clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
