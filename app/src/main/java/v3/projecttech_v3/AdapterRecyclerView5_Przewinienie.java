package v3.projecttech_v3;


import static v3.projecttech_v3.Przewinienie_Activity.FinalListWithCellColor;
import static v3.projecttech_v3.Przewinienie_Activity.FinalListWithColumnsAdjust;
import static v3.projecttech_v3.Przewinienie_Activity.database_Przewinienie;
import static v3.projecttech_v3.Przewinienie_Activity.inputPrzewinienie2;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView5_Przewinienie extends RecyclerView.Adapter<AdapterRecyclerView5_Przewinienie.ViewHolderRecyclerView> {

    int positionAdapterPrzewinienie;
    String positionAdapterPrzewinienieText;

    private final RecyclerViewInterface5_Przewinienie recyclerViewInterface;
    Context context;
    ArrayList<ArrayList<String>> data;

    public AdapterRecyclerView5_Przewinienie(Context context1, ArrayList<ArrayList<String>> dataIn, RecyclerViewInterface5_Przewinienie recyclerViewInterface) {
        this.context = context1;
        this.data = dataIn;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public AdapterRecyclerView5_Przewinienie.ViewHolderRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.linear_layout_rows5_przewinienie, parent, false);
        return new ViewHolderRecyclerView(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView5_Przewinienie.ViewHolderRecyclerView holder, int position) {

        holder.textView1.setText(database_Przewinienie.get(position).get(0).toString());
        holder.textView2.setText(database_Przewinienie.get(position).get(1).toString());
        holder.textView3.setText(database_Przewinienie.get(position).get(2).toString());
        holder.textView4.setText(database_Przewinienie.get(position).get(3).toString());
        holder.textView5.setText(database_Przewinienie.get(position).get(4).toString());
        holder.textView6.setText(database_Przewinienie.get(position).get(5).toString());
        holder.textView7.setText(database_Przewinienie.get(position).get(6).toString());
        holder.textView8.setText(database_Przewinienie.get(position).get(7).toString());

        holder.textView1.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));
        holder.textView2.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));
        holder.textView3.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));
        holder.textView4.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));
        holder.textView5.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));
        holder.textView6.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));
        holder.textView7.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));
        holder.textView8.setBackgroundColor(Color.parseColor(FinalListWithCellColor.get(position)));

        holder.textView1.setGravity(FinalListWithColumnsAdjust.get(0));
        holder.textView2.setGravity(FinalListWithColumnsAdjust.get(1));
        holder.textView3.setGravity(FinalListWithColumnsAdjust.get(2));
        holder.textView4.setGravity(FinalListWithColumnsAdjust.get(3));
        holder.textView5.setGravity(FinalListWithColumnsAdjust.get(4));
        holder.textView6.setGravity(FinalListWithColumnsAdjust.get(5));
        holder.textView7.setGravity(FinalListWithColumnsAdjust.get(6));
        holder.textView8.setGravity(FinalListWithColumnsAdjust.get(7));

        ViewGroup.LayoutParams params1 = holder.textView1.getLayoutParams();
        ViewGroup.LayoutParams params2 = holder.textView2.getLayoutParams();
        ViewGroup.LayoutParams params3 = holder.textView3.getLayoutParams();
        ViewGroup.LayoutParams params4 = holder.textView4.getLayoutParams();
        ViewGroup.LayoutParams params5 = holder.textView5.getLayoutParams();
        ViewGroup.LayoutParams params6 = holder.textView6.getLayoutParams();
        ViewGroup.LayoutParams params7 = holder.textView7.getLayoutParams();
        ViewGroup.LayoutParams params8 = holder.textView8.getLayoutParams();

        params1.width = 0;
        params2.width = 0;
        params3.width = 100;
        params4.width = 500;
        params5.width = 0;
        params6.width = 0;
        params7.width = 400;
        params8.width = 400;

        holder.textView1.setLayoutParams(params1);
        holder.textView2.setLayoutParams(params2);
        holder.textView3.setLayoutParams(params3);
        holder.textView4.setLayoutParams(params4);
        holder.textView5.setLayoutParams(params5);
        holder.textView6.setLayoutParams(params6);
        holder.textView7.setLayoutParams(params7);
        holder.textView8.setLayoutParams(params8);
        
    }

    @Override
    public int getItemCount() {
        return database_Przewinienie.size();
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


        public ViewHolderRecyclerView(@NonNull View itemView, RecyclerViewInterface5_Przewinienie recyclerViewInterface)
        {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
            textView8 = itemView.findViewById(R.id.textView8);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        positionAdapterPrzewinienie = getAdapterPosition();
                        positionAdapterPrzewinienieText = database_Przewinienie.get(positionAdapterPrzewinienie).get(3).toString();
                        inputPrzewinienie2.setText(positionAdapterPrzewinienieText);
                        Toast.makeText(context, "Position: " + positionAdapterPrzewinienieText, Toast.LENGTH_SHORT).show();

                        if (positionAdapterPrzewinienie != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(positionAdapterPrzewinienie);
                        }
                    }
                }
            });
        }
    }
}
