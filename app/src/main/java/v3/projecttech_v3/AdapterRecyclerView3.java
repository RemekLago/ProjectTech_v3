package v3.projecttech_v3;

import static v3.projecttech_v3.MainActivity_Procedura_PozycjaPartia_HistoriaZycia.FinalListWithCellColor3;
import static v3.projecttech_v3.MainActivity_Procedura_PozycjaPartia_HistoriaZycia.FinalListWithColumnsAdjust3;
import static v3.projecttech_v3.MainActivity_Procedura_PozycjaPartia_HistoriaZycia.dataBaseSQL3;
import static v3.projecttech_v3.formularz1.Formularz1_InformacjeOPozycji_MainActivity_Table2.database3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterRecyclerView3 extends RecyclerView.Adapter<AdapterRecyclerView3.ViewHolderRecyclerView> {

    private final RecyclerViewInterface3 recyclerViewInterface3;

    Context context3;
    ArrayList<ArrayList<String>> data3;

    public AdapterRecyclerView3 (Context context1, ArrayList<ArrayList<String>> dataIn, RecyclerViewInterface3 recyclerViewInterface3) {
        this.context3 = context1;
        this.data3 = dataIn;
        this.recyclerViewInterface3 = recyclerViewInterface3;
    }

    @NonNull
    @Override
    public v3.projecttech_v3.AdapterRecyclerView3.ViewHolderRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context3);
        View view = inflater.inflate(R.layout.linear_layout_rows2, parent, false);
        return new v3.projecttech_v3.AdapterRecyclerView3.ViewHolderRecyclerView(view, recyclerViewInterface3);

    }

    @Override
    public void onBindViewHolder(@NonNull v3.projecttech_v3.AdapterRecyclerView3.ViewHolderRecyclerView holder, int i) {

        holder.textView1_3.setText(dataBaseSQL3.getDataId(i+1).getRawColor());
        holder.textView2_3.setText(dataBaseSQL3.getDataId(i+1).getLock());
        holder.textView3_3.setText(dataBaseSQL3.getDataId(i+1).getLp());
        holder.textView4_3.setText(dataBaseSQL3.getDataId(i+1).getTypkonfekcji());
        holder.textView5_3.setText(dataBaseSQL3.getDataId(i+1).getKonfekcja());
        holder.textView6_3.setText(dataBaseSQL3.getDataId(i+1).getIlosc());
        holder.textView7_3.setText(dataBaseSQL3.getDataId(i+1).getOperator());
        holder.textView8_3.setText(dataBaseSQL3.getDataId(i+1).getAdddate());

        holder.textView1_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));
        holder.textView2_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));
        holder.textView3_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));
        holder.textView4_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));
        holder.textView5_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));
        holder.textView6_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));
        holder.textView7_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));
        holder.textView8_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor3.get(i)));

        holder.textView1_3.setGravity(FinalListWithColumnsAdjust3.get(0));
        holder.textView2_3.setGravity(FinalListWithColumnsAdjust3.get(1));
        holder.textView3_3.setGravity(FinalListWithColumnsAdjust3.get(2));
        holder.textView4_3.setGravity(FinalListWithColumnsAdjust3.get(3));
        holder.textView5_3.setGravity(FinalListWithColumnsAdjust3.get(4));
        holder.textView6_3.setGravity(FinalListWithColumnsAdjust3.get(5));
        holder.textView7_3.setGravity(FinalListWithColumnsAdjust3.get(6));
        holder.textView8_3.setGravity(FinalListWithColumnsAdjust3.get(7));

        ViewGroup.LayoutParams params1 = holder.textView1_3.getLayoutParams();
        ViewGroup.LayoutParams params2 = holder.textView2_3.getLayoutParams();
        ViewGroup.LayoutParams params3 = holder.textView3_3.getLayoutParams();
        ViewGroup.LayoutParams params4 = holder.textView4_3.getLayoutParams();
        ViewGroup.LayoutParams params5 = holder.textView5_3.getLayoutParams();
        ViewGroup.LayoutParams params6 = holder.textView6_3.getLayoutParams();
        ViewGroup.LayoutParams params7 = holder.textView7_3.getLayoutParams();
        ViewGroup.LayoutParams params8 = holder.textView8_3.getLayoutParams();
//        params1.width = FinalListWithColumnsWidth3.get(0);
//        params2.width = FinalListWithColumnsWidth3.get(1);
//        params3.width = FinalListWithColumnsWidth3.get(2);
//        params4.width = FinalListWithColumnsWidth3.get(3);
//        params5.width = FinalListWithColumnsWidth3.get(4);
//        params6.width = FinalListWithColumnsWidth3.get(5);
//        params7.width = FinalListWithColumnsWidth3.get(6);
//        params8.width = FinalListWithColumnsWidth3.get(7);
        params1.width = 0;
        params2.width = 0;
        params3.width = 100;
        params4.width = 350;
        params5.width = 350;
        params6.width = 200;
        params7.width = 500;
        params8.width = 300;
        holder.textView1_3.setLayoutParams(params1);
        holder.textView2_3.setLayoutParams(params2);
        holder.textView3_3.setLayoutParams(params3);
        holder.textView4_3.setLayoutParams(params4);
        holder.textView5_3.setLayoutParams(params5);
        holder.textView6_3.setLayoutParams(params6);
        holder.textView7_3.setLayoutParams(params7);
        holder.textView8_3.setLayoutParams(params8);



    }

    @Override
    public int getItemCount() {
        return database3.size();
    }

    public class ViewHolderRecyclerView extends RecyclerView.ViewHolder {

        TextView textView1_3;
        TextView textView2_3;
        TextView textView3_3;
        TextView textView4_3;
        TextView textView5_3;
        TextView textView6_3;
        TextView textView7_3;
        TextView textView8_3;


        public ViewHolderRecyclerView(@NonNull View itemView, RecyclerViewInterface3 recyclerViewInterface3) {
            super(itemView);


            textView1_3 = itemView.findViewById(R.id.textView1_3);
            textView2_3 = itemView.findViewById(R.id.textView2_3);
            textView3_3 = itemView.findViewById(R.id.textView3_3);
            textView4_3 = itemView.findViewById(R.id.textView4_3);
            textView5_3 = itemView.findViewById(R.id.textView5_3);
            textView6_3 = itemView.findViewById(R.id.textView6_3);
            textView7_3 = itemView.findViewById(R.id.textView7_3);
            textView8_3 = itemView.findViewById(R.id.textView8_3);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface3 != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface3.onItemClick3(position);
                        }
                    }
                }
            });

        }
    }
}
