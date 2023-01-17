package v3.projecttech_v3;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapertRecyclerView5_Zdjęcie extends RecyclerView.Adapter<AdapertRecyclerView5_Zdjęcie.ViewHolder> {

    ArrayList<Bitmap> tmpImages;
    LayoutInflater inflater;
    public static ArrayList<ArrayList<String>> tmpUserSettings2;



    public AdapertRecyclerView5_Zdjęcie(Context context, ArrayList<Bitmap> tmpImages) {
        this.tmpImages = tmpImages;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapertRecyclerView5_Zdjęcie.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.zdjecia_grid_layout, parent, false);
        return new AdapertRecyclerView5_Zdjęcie.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gridIcon.setImageBitmap(tmpImages.get(position));
//        holder.gridIcon.setImageDrawable(tmpImages.get(position));

    }

    @Override
    public int getItemCount() {
        return tmpImages.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gridIcon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gridIcon = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
