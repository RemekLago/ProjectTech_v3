package v3.projecttech_v3;

import static v3.projecttech_v3.MainActivity_Table.FinalListWithCellColor;
import static v3.projecttech_v3.MainActivity_Table.FinalListWithColumnsAdjust;
import static v3.projecttech_v3.MainActivity_Table.FinalListWithColumnsWidth;
import static v3.projecttech_v3.MainActivity_Table.database;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolderRecyclerView> {

    private final RecyclerViewInterface recyclerViewInterface;
    public static long position2;

    Context context;
    ArrayList<ArrayList<String>> data1;

    public AdapterRecyclerView (Context context1, ArrayList<ArrayList<String>> dataIn, RecyclerViewInterface recyclerViewInterface) {
        this.context = context1;
        this.data1 = dataIn;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolderRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.linear_layout_rows, parent, false);
        return new ViewHolderRecyclerView(view, recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolderRecyclerView holder, int i) {

        Log.i("checking", "dana1: " + database.get(i).get(2).toString());

        holder.textView1.setText(database.get(i).get(0).toString());
        holder.textView2.setText(database.get(i).get(1).toString());
        holder.textView3.setText(database.get(i).get(2).toString());
        holder.textView4.setText(database.get(i).get(3).toString());
        holder.textView5.setText(database.get(i).get(4).toString());
        holder.textView6.setText(database.get(i).get(5).toString());
        holder.textView7.setText(database.get(i).get(6).toString());
        holder.textView8.setText(database.get(i).get(7).toString());
        holder.textView9.setText(database.get(i).get(8).toString());
        holder.textView10.setText(database.get(i).get(9).toString());
        holder.textView11.setText(database.get(i).get(10).toString());
        holder.textView12.setText(database.get(i).get(11).toString());
        holder.textView13.setText(database.get(i).get(12).toString());
        holder.textView14.setText(database.get(i).get(13).toString());
        holder.textView15.setText(database.get(i).get(14).toString());

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
            params1.width = FinalListWithColumnsWidth.get(0);
            params2.width = FinalListWithColumnsWidth.get(1);
            params3.width = FinalListWithColumnsWidth.get(2);
            params4.width = FinalListWithColumnsWidth.get(3);
            params5.width = FinalListWithColumnsWidth.get(4);
            params6.width = FinalListWithColumnsWidth.get(5);
            params7.width = FinalListWithColumnsWidth.get(6);
            params8.width = FinalListWithColumnsWidth.get(7);
            params9.width = FinalListWithColumnsWidth.get(8);
            params10.width = FinalListWithColumnsWidth.get(9);
            params11.width = FinalListWithColumnsWidth.get(10);
            params12.width = FinalListWithColumnsWidth.get(11);
            params13.width = FinalListWithColumnsWidth.get(12);
            params14.width = FinalListWithColumnsWidth.get(13);
            params15.width = FinalListWithColumnsWidth.get(14);
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


    }

    @Override
    public int getItemCount() {
        return database.size();
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        position2 = AdapterRecyclerView.this.getItemId(position);
//                        long positionChild = getItemId();


                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}