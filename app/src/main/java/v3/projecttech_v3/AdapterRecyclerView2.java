package v3.projecttech_v3;



import static v3.projecttech_v3.MainActivity_Table2.FinalListWithCellColor;
import static v3.projecttech_v3.MainActivity_Table2.FinalListWithColumnsAdjust;
import static v3.projecttech_v3.MainActivity_Table2.FinalListWithColumnsWidth;
import static v3.projecttech_v3.MainActivity_Table2.dataBaseSQL;
import static v3.projecttech_v3.MainActivity_Table2.database2;
import static v3.projecttech_v3.MainActivity_Table2.intent10;
import static v3.projecttech_v3.MainActivity_Table2.intent11;
import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.rPozycja;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterRecyclerView2 extends RecyclerView.Adapter<AdapterRecyclerView2.ViewHolderRecyclerView> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context2;
    ArrayList<ArrayList<String>> data2;

    public AdapterRecyclerView2 (Context context1, ArrayList<ArrayList<String>> dataIn, RecyclerViewInterface recyclerViewInterface) {
        this.context2 = context1;
        this.data2 = dataIn;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public AdapterRecyclerView2.ViewHolderRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context2);
        View view = inflater.inflate(R.layout.linear_layout_rows, parent, false);
        return new ViewHolderRecyclerView(view, recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView2.ViewHolderRecyclerView holder, int i) {

        holder.textView1.setText(dataBaseSQL.getDataId(i+1).getRawColor());
        holder.textView2.setText(dataBaseSQL.getDataId(i+1).getLock());
        holder.textView3.setText(dataBaseSQL.getDataId(i+1).getLp());
        holder.textView4.setText(dataBaseSQL.getDataId(i+1).getMagazyn());
        holder.textView5.setText(dataBaseSQL.getDataId(i+1).getLokalizacja());
        holder.textView6.setText(dataBaseSQL.getDataId(i+1).getPartia());
        holder.textView7.setText(dataBaseSQL.getDataId(i+1).getWariant());
        holder.textView8.setText(dataBaseSQL.getDataId(i+1).getWariantOpis());
        holder.textView9.setText(dataBaseSQL.getDataId(i+1).getPartiaZlecenie());
        holder.textView10.setText(dataBaseSQL.getDataId(i+1).getKonfekcja());
        holder.textView11.setText(dataBaseSQL.getDataId(i+1).getIlwkonf());
        holder.textView12.setText(dataBaseSQL.getDataId(i+1).getIlszt());
        holder.textView13.setText(dataBaseSQL.getDataId(i+1).getIloscKm());
        holder.textView14.setText(dataBaseSQL.getDataId(i+1).getRez());
        holder.textView15.setText(dataBaseSQL.getDataId(i+1).getSource());

        holder.textView1.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView2.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView4.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView5.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView6.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView7.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView8.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView9.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView10.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView11.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView12.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView13.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView14.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView15.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));

        holder.textView1.setGravity(FinalListWithColumnsAdjust.get(0));
        holder.textView2.setGravity(FinalListWithColumnsAdjust.get(1));
        holder.textView3.setGravity(FinalListWithColumnsAdjust.get(2));
        holder.textView4.setGravity(FinalListWithColumnsAdjust.get(3));
        holder.textView5.setGravity(FinalListWithColumnsAdjust.get(4));
        holder.textView6.setGravity(FinalListWithColumnsAdjust.get(5));
        holder.textView7.setGravity(FinalListWithColumnsAdjust.get(6));
        holder.textView8.setGravity(FinalListWithColumnsAdjust.get(7));
        holder.textView9.setGravity(FinalListWithColumnsAdjust.get(8));
        holder.textView10.setGravity(FinalListWithColumnsAdjust.get(9));
        holder.textView11.setGravity(FinalListWithColumnsAdjust.get(10));
        holder.textView12.setGravity(FinalListWithColumnsAdjust.get(11));
        holder.textView13.setGravity(FinalListWithColumnsAdjust.get(12));
        holder.textView14.setGravity(FinalListWithColumnsAdjust.get(13));
        holder.textView15.setGravity(FinalListWithColumnsAdjust.get(14));

        ViewGroup.LayoutParams params1 = holder.textView1.getLayoutParams();
        ViewGroup.LayoutParams params2 = holder.textView2.getLayoutParams();
        ViewGroup.LayoutParams params3 = holder.textView3.getLayoutParams();
        ViewGroup.LayoutParams params4 = holder.textView4.getLayoutParams();
        ViewGroup.LayoutParams params5 = holder.textView5.getLayoutParams();
        ViewGroup.LayoutParams params6 = holder.textView6.getLayoutParams();
        ViewGroup.LayoutParams params7 = holder.textView7.getLayoutParams();
        ViewGroup.LayoutParams params8 = holder.textView8.getLayoutParams();
        ViewGroup.LayoutParams params9 = holder.textView9.getLayoutParams();
        ViewGroup.LayoutParams params10 = holder.textView10.getLayoutParams();
        ViewGroup.LayoutParams params11 = holder.textView11.getLayoutParams();
        ViewGroup.LayoutParams params12 = holder.textView12.getLayoutParams();
        ViewGroup.LayoutParams params13 = holder.textView13.getLayoutParams();
        ViewGroup.LayoutParams params14 = holder.textView14.getLayoutParams();
        ViewGroup.LayoutParams params15 = holder.textView15.getLayoutParams();
//        params1.width = FinalListWithColumnsWidth.get(0);
//        params2.width = FinalListWithColumnsWidth.get(1);
//        params3.width = FinalListWithColumnsWidth.get(2);
//        params4.width = FinalListWithColumnsWidth.get(3);
//        params5.width = FinalListWithColumnsWidth.get(4);
//        params6.width = FinalListWithColumnsWidth.get(5);
//        params7.width = FinalListWithColumnsWidth.get(6);
//        params8.width = FinalListWithColumnsWidth.get(7);
//        params9.width = FinalListWithColumnsWidth.get(8);
//        params10.width = FinalListWithColumnsWidth.get(9);
//        params11.width = FinalListWithColumnsWidth.get(10);
//        params12.width = FinalListWithColumnsWidth.get(11);
//        params13.width = FinalListWithColumnsWidth.get(12);
//        params14.width = FinalListWithColumnsWidth.get(13);
//        params15.width = FinalListWithColumnsWidth.get(14);
        params1.width = 0;
        params2.width = 0;
        params3.width = 100;
        params4.width = 250;
        params5.width = 300;
        params6.width = 450;
        params7.width = 300;
        params8.width = 350;
        params9.width = 400;
        params10.width = 400;
        params11.width = 350;
        params12.width = 400;
        params13.width = 200;
        params14.width = 200;
        params15.width = 0;
        holder.textView1.setLayoutParams(params1);
        holder.textView2.setLayoutParams(params2);
        holder.textView3.setLayoutParams(params3);
        holder.textView4.setLayoutParams(params4);
        holder.textView5.setLayoutParams(params5);
        holder.textView6.setLayoutParams(params6);
        holder.textView7.setLayoutParams(params7);
        holder.textView8.setLayoutParams(params8);
        holder.textView9.setLayoutParams(params9);
        holder.textView10.setLayoutParams(params10);
        holder.textView11.setLayoutParams(params11);
        holder.textView12.setLayoutParams(params12);
        holder.textView13.setLayoutParams(params13);
        holder.textView14.setLayoutParams(params14);
        holder.textView15.setLayoutParams(params15);

        holder.linearLayoutExpand.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        holder.button_PozycjaPartia_historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent10 = new Intent(context2, MainActivity_Procedura_PozycjaPartia_HistoriaZycia.class);
                context2.startActivity(intent10);
            }
        });

        holder.button_Magazyn_Lokalizacja_Pozycja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent11 = new Intent(context2, MainActivity_Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycja.class);
                context2.startActivity(intent11);
            }
        });

    }

    @Override
    public int getItemCount() {
        return database2.size();
    }

    public class ViewHolderRecyclerView extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        TextView textView15;

        Button button_PozycjaPartia_historia;
        Button button_Magazyn_Lokalizacja_Pozycja;
        LinearLayout linearLayoutExpand;

        public ViewHolderRecyclerView(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);


            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
            textView8 = itemView.findViewById(R.id.textView8);
            textView9 = itemView.findViewById(R.id.textView9);
            textView10 = itemView.findViewById(R.id.textView10);
            textView11 = itemView.findViewById(R.id.textView11);
            textView12 = itemView.findViewById(R.id.textView12);
            textView13 = itemView.findViewById(R.id.textView13);
            textView14 = itemView.findViewById(R.id.textView14);
            textView15 = itemView.findViewById(R.id.textView15);

            button_Magazyn_Lokalizacja_Pozycja = itemView.findViewById(R.id.button_Magazyn_Lokalizacja_Pozycja);
            button_PozycjaPartia_historia = itemView.findViewById(R.id.button_PozycjaPartia_historia);
            linearLayoutExpand = itemView.findViewById(R.id.layout_expand);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        int v = (button_PozycjaPartia_historia.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                        TransitionManager.beginDelayedTransition(linearLayoutExpand, new AutoTransition());
                        button_PozycjaPartia_historia.setVisibility(v);


                        int w = (button_Magazyn_Lokalizacja_Pozycja.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                        TransitionManager.beginDelayedTransition(linearLayoutExpand, new AutoTransition());
                        button_Magazyn_Lokalizacja_Pozycja.setVisibility(w);

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });

        }

    }



}