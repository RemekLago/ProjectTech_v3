package v3.projecttech_v3;

import static v3.projecttech_v3.MainActivity_Table2.FinalListWithCellColor;
import static v3.projecttech_v3.MainActivity_Table2.FinalListWithColumnsAdjust;
import static v3.projecttech_v3.MainActivity_Table2.FinalListWithColumnsWidth;
import static v3.projecttech_v3.MainActivity_Table2.dataBaseSQL;
import static v3.projecttech_v3.MainActivity_Table2.database3;

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

    private final RecyclerViewInterface recyclerViewInterface;

    Context context3;
    ArrayList<ArrayList<String>> data3;

    public AdapterRecyclerView3 (Context context1, ArrayList<ArrayList<String>> dataIn, RecyclerViewInterface recyclerViewInterface) {
        this.context3 = context1;
        this.data3 = dataIn;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public v3.projecttech_v3.AdapterRecyclerView3.ViewHolderRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context3);
        View view = inflater.inflate(R.layout.linear_layout_rows2, parent, false);
        return new v3.projecttech_v3.AdapterRecyclerView3.ViewHolderRecyclerView(view, recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull v3.projecttech_v3.AdapterRecyclerView3.ViewHolderRecyclerView holder, int i) {

        holder.textView1_3.setText(dataBaseSQL.getDataId(i+1).getRawColor());
        holder.textView2_3.setText(dataBaseSQL.getDataId(i+1).getLock());
        holder.textView3_3.setText(dataBaseSQL.getDataId(i+1).getLp());
        holder.textView4_3.setText(dataBaseSQL.getDataId(i+1).getMagazyn());
        holder.textView5_3.setText(dataBaseSQL.getDataId(i+1).getLokalizacja());
        holder.textView6_3.setText(dataBaseSQL.getDataId(i+1).getPartia());
        holder.textView7_3.setText(dataBaseSQL.getDataId(i+1).getWariant());
        holder.textView8_3.setText(dataBaseSQL.getDataId(i+1).getWariantOpis());

        holder.textView1_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView2_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView3_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView4_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView5_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView6_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView7_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));
        holder.textView8_3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(i)));

        holder.textView1_3.setGravity(FinalListWithColumnsAdjust.get(0));
        holder.textView2_3.setGravity(FinalListWithColumnsAdjust.get(1));
        holder.textView3_3.setGravity(FinalListWithColumnsAdjust.get(2));
        holder.textView4_3.setGravity(FinalListWithColumnsAdjust.get(3));
        holder.textView5_3.setGravity(FinalListWithColumnsAdjust.get(4));
        holder.textView6_3.setGravity(FinalListWithColumnsAdjust.get(5));
        holder.textView7_3.setGravity(FinalListWithColumnsAdjust.get(6));
        holder.textView8_3.setGravity(FinalListWithColumnsAdjust.get(7));

        ViewGroup.LayoutParams params1 = holder.textView1_3.getLayoutParams();
        ViewGroup.LayoutParams params2 = holder.textView2_3.getLayoutParams();
        ViewGroup.LayoutParams params3 = holder.textView3_3.getLayoutParams();
        ViewGroup.LayoutParams params4 = holder.textView4_3.getLayoutParams();
        ViewGroup.LayoutParams params5 = holder.textView5_3.getLayoutParams();
        ViewGroup.LayoutParams params6 = holder.textView6_3.getLayoutParams();
        ViewGroup.LayoutParams params7 = holder.textView7_3.getLayoutParams();
        ViewGroup.LayoutParams params8 = holder.textView8_3.getLayoutParams();
        params1.width = FinalListWithColumnsWidth.get(0);
        params2.width = FinalListWithColumnsWidth.get(1);
        params3.width = FinalListWithColumnsWidth.get(2);
        params4.width = FinalListWithColumnsWidth.get(3);
        params5.width = FinalListWithColumnsWidth.get(4);
        params6.width = FinalListWithColumnsWidth.get(5);
        params7.width = FinalListWithColumnsWidth.get(6);
        params8.width = FinalListWithColumnsWidth.get(7);
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


        public ViewHolderRecyclerView(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
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
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
