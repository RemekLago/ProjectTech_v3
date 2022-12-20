package v3.projecttech_v3;



import static v3.projecttech_v3.formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.FinalListWithCellColor4;
import static v3.projecttech_v3.formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.FinalListWithColumnsAdjust4;
import static v3.projecttech_v3.formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.dataBaseSQL4;
import static v3.projecttech_v3.formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.database4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView4 extends RecyclerView.Adapter<AdapterRecyclerView4.ViewHolderRecyclerView> {

    private final RecyclerViewInterface4 recyclerViewInterface4;

    Context context4;
    ArrayList<ArrayList<String>> data4;

    public AdapterRecyclerView4 (Context context1, ArrayList<ArrayList<String>> dataIn, RecyclerViewInterface4 recyclerViewInterface4) {
        this.context4 = context1;
        this.data4 = dataIn;
        this.recyclerViewInterface4 = recyclerViewInterface4;
    }


    @NonNull
    @Override
    public AdapterRecyclerView4.ViewHolderRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context4);
        View view = inflater.inflate(R.layout.linear_layout_rows3, parent, false);
        return new ViewHolderRecyclerView(view, recyclerViewInterface4);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView4.ViewHolderRecyclerView holder, int i) {

        holder.textView1_4.setText(dataBaseSQL4.getDataId(i+1).getRawColor());
        holder.textView2_4.setText(dataBaseSQL4.getDataId(i+1).getLock());
        holder.textView3_4.setText(dataBaseSQL4.getDataId(i+1).getLp());
        holder.textView4_4.setText(dataBaseSQL4.getDataId(i+1).getPozycja());
        holder.textView5_4.setText(dataBaseSQL4.getDataId(i+1).getPozycjanazwa());
        holder.textView6_4.setText(dataBaseSQL4.getDataId(i+1).getPartia());
        holder.textView7_4.setText(dataBaseSQL4.getDataId(i+1).getWariant());
        holder.textView8_4.setText(dataBaseSQL4.getDataId(i+1).getWariantOpis());
        holder.textView9_4.setText(dataBaseSQL4.getDataId(i+1).getPartiaZlecenie());
        holder.textView10_4.setText(dataBaseSQL4.getDataId(i+1).getKonfekcja());
        holder.textView11_4.setText(dataBaseSQL4.getDataId(i+1).getIlwkonf());
        holder.textView12_4.setText(dataBaseSQL4.getDataId(i+1).getIlszt());
        holder.textView13_4.setText(dataBaseSQL4.getDataId(i+1).getIloscKm());
        holder.textView14_4.setText(dataBaseSQL4.getDataId(i+1).getRez());
        holder.textView15_4.setText(dataBaseSQL4.getDataId(i+1).getSource());

        holder.textView1_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView2_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView3_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView4_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView5_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView6_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView7_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView8_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView9_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView10_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView11_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView12_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView13_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView14_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));
        holder.textView15_4.setBackgroundColor(Color.parseColor(FinalListWithCellColor4.get(i)));

        holder.textView1_4.setGravity(FinalListWithColumnsAdjust4.get(0));
        holder.textView2_4.setGravity(FinalListWithColumnsAdjust4.get(1));
        holder.textView3_4.setGravity(FinalListWithColumnsAdjust4.get(2));
        holder.textView4_4.setGravity(FinalListWithColumnsAdjust4.get(3));
        holder.textView5_4.setGravity(FinalListWithColumnsAdjust4.get(4));
        holder.textView6_4.setGravity(FinalListWithColumnsAdjust4.get(5));
        holder.textView7_4.setGravity(FinalListWithColumnsAdjust4.get(6));
        holder.textView8_4.setGravity(FinalListWithColumnsAdjust4.get(7));
        holder.textView9_4.setGravity(FinalListWithColumnsAdjust4.get(8));
        holder.textView10_4.setGravity(FinalListWithColumnsAdjust4.get(9));
        holder.textView11_4.setGravity(FinalListWithColumnsAdjust4.get(10));
        holder.textView12_4.setGravity(FinalListWithColumnsAdjust4.get(11));
        holder.textView13_4.setGravity(FinalListWithColumnsAdjust4.get(12));
        holder.textView14_4.setGravity(FinalListWithColumnsAdjust4.get(13));
        holder.textView15_4.setGravity(FinalListWithColumnsAdjust4.get(14));

        ViewGroup.LayoutParams params1 = holder.textView1_4.getLayoutParams();
        ViewGroup.LayoutParams params2 = holder.textView2_4.getLayoutParams();
        ViewGroup.LayoutParams params3 = holder.textView3_4.getLayoutParams();
        ViewGroup.LayoutParams params4 = holder.textView4_4.getLayoutParams();
        ViewGroup.LayoutParams params5 = holder.textView5_4.getLayoutParams();
        ViewGroup.LayoutParams params6 = holder.textView6_4.getLayoutParams();
        ViewGroup.LayoutParams params7 = holder.textView7_4.getLayoutParams();
        ViewGroup.LayoutParams params8 = holder.textView8_4.getLayoutParams();
        ViewGroup.LayoutParams params9 = holder.textView9_4.getLayoutParams();
        ViewGroup.LayoutParams params10 = holder.textView10_4.getLayoutParams();
        ViewGroup.LayoutParams params11 = holder.textView11_4.getLayoutParams();
        ViewGroup.LayoutParams params12 = holder.textView12_4.getLayoutParams();
        ViewGroup.LayoutParams params13 = holder.textView13_4.getLayoutParams();
        ViewGroup.LayoutParams params14 = holder.textView14_4.getLayoutParams();
        ViewGroup.LayoutParams params15 = holder.textView15_4.getLayoutParams();
//        params1.width = FinalListWithColumnsWidth4.get(0);
//        params2.width = FinalListWithColumnsWidth4.get(1);
//        params3.width = FinalListWithColumnsWidth4.get(2);
//        params4.width = FinalListWithColumnsWidth4.get(3);
//        params5.width = FinalListWithColumnsWidth4.get(4);
//        params6.width = FinalListWithColumnsWidth4.get(5);
//        params7.width = FinalListWithColumnsWidth4.get(6);
//        params8.width = FinalListWithColumnsWidth4.get(7);
//        params9.width = FinalListWithColumnsWidth4.get(8);
//        params10.width = FinalListWithColumnsWidth4.get(9);
//        params11.width = FinalListWithColumnsWidth4.get(10);
//        params12.width = FinalListWithColumnsWidth4.get(11);
//        params13.width = FinalListWithColumnsWidth4.get(12);
//        params14.width = FinalListWithColumnsWidth4.get(13);
//        params15.width = FinalListWithColumnsWidth4.get(14);
        params1.width = 0;
        params2.width = 0;
        params3.width = 100;
        params4.width = 300;
        params5.width = 400;
        params6.width = 400;
        params7.width = 250;
        params8.width = 0;
        params9.width = 0;
        params10.width = 0;
        params11.width = 0;
        params12.width = 0;
        params13.width = 0;
        params14.width = 0;
        params15.width = 0;
        holder.textView1_4.setLayoutParams(params1);
        holder.textView2_4.setLayoutParams(params2);
        holder.textView3_4.setLayoutParams(params3);
        holder.textView4_4.setLayoutParams(params4);
        holder.textView5_4.setLayoutParams(params5);
        holder.textView6_4.setLayoutParams(params6);
        holder.textView7_4.setLayoutParams(params7);
        holder.textView8_4.setLayoutParams(params8);
        holder.textView9_4.setLayoutParams(params9);
        holder.textView10_4.setLayoutParams(params10);
        holder.textView11_4.setLayoutParams(params11);
        holder.textView12_4.setLayoutParams(params12);
        holder.textView13_4.setLayoutParams(params13);
        holder.textView14_4.setLayoutParams(params14);
        holder.textView15_4.setLayoutParams(params15);
    }

    @Override
    public int getItemCount() {
        return database4.size();
    }

    public class ViewHolderRecyclerView extends RecyclerView.ViewHolder {

        TextView textView1_4;
        TextView textView2_4;
        TextView textView3_4;
        TextView textView4_4;
        TextView textView5_4;
        TextView textView6_4;
        TextView textView7_4;
        TextView textView8_4;
        TextView textView9_4;
        TextView textView10_4;
        TextView textView11_4;
        TextView textView12_4;
        TextView textView13_4;
        TextView textView14_4;
        TextView textView15_4;

        public ViewHolderRecyclerView(@NonNull View itemView, RecyclerViewInterface4 recyclerViewInterface4) {
            super(itemView);


            textView1_4 = itemView.findViewById(R.id.textView1_4);
            textView2_4 = itemView.findViewById(R.id.textView2_4);
            textView3_4 = itemView.findViewById(R.id.textView3_4);
            textView4_4 = itemView.findViewById(R.id.textView4_4);
            textView5_4 = itemView.findViewById(R.id.textView5_4);
            textView6_4 = itemView.findViewById(R.id.textView6_4);
            textView7_4 = itemView.findViewById(R.id.textView7_4);
            textView8_4 = itemView.findViewById(R.id.textView8_4);
            textView9_4 = itemView.findViewById(R.id.textView9_4);
            textView10_4 = itemView.findViewById(R.id.textView10_4);
            textView11_4 = itemView.findViewById(R.id.textView11_4);
            textView12_4 = itemView.findViewById(R.id.textView12_4);
            textView13_4 = itemView.findViewById(R.id.textView13_4);
            textView14_4 = itemView.findViewById(R.id.textView14_4);
            textView15_4 = itemView.findViewById(R.id.textView15_4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface4 != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface4.onItemClick4(position);
                        }
                    }
                }
            });

        }
    }
}
