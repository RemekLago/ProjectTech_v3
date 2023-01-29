package v3.projecttech_v3.formularz5;

import static v3.projecttech_v3.formularz5.Photo_Activity.imageViewPhoto;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import v3.projecttech_v3.R;

public class AdapterRecyclerView5_ZdjecieMini extends RecyclerView.Adapter<AdapterRecyclerView5_ZdjecieMini.ViewHolder> {

    ArrayList<Bitmap> tmpImages;
    LayoutInflater inflater;
    private Context context;

    public static ArrayList<ArrayList<String>> tmpUserSettings2;



    public AdapterRecyclerView5_ZdjecieMini(Context context, ArrayList<Bitmap> tmpImages) {
        this.tmpImages = tmpImages;
        this.context = context;
//        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.formularz5_zdjecia_mini_grid_layout, parent, false);

        return new AdapterRecyclerView5_ZdjecieMini.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView5_ZdjecieMini.ViewHolder holder, int position) {
        holder.gridIcon.setImageBitmap(tmpImages.get(position));

        int position1 = holder.getAdapterPosition();
        Log.i("Checking", "position1: " + position1);


       holder.gridIcon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               imageViewPhoto.setImageBitmap(tmpImages.get(position1));
               Log.i("Checking", "tmpImages click: " + position1);
           }
       });

       holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmpImages.remove(tmpImages.get(position1));
                Log.i("Checking", "tmpImages size: " + tmpImages.size());
                Log.i("Checking", "tmpImages.remove: " + position1);
                notifyItemRemoved(position1);
                notifyItemRangeChanged(position1, getItemCount());
            }
        });

        Glide.with(context)
                .load(tmpImages.get(position))
                .into(holder.gridIcon);

    }

    @Override
    public int getItemCount() {
        return tmpImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gridIcon;
        ImageView deleteIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gridIcon = itemView.findViewById(R.id.image);
            deleteIcon = itemView.findViewById(R.id.delete_icon);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.i("Checking", "position1: " + getAdapterPosition());
//                }
//            });
        }
    }
}
