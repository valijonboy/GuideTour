package pop.uz.guidetour.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pop.uz.guidetour.R;
import pop.uz.guidetour.model.Bulvar;

public class BulvarAdapter extends RecyclerView.Adapter<BulvarAdapter.BulvarViewHolder> {

    public static ArrayList<Bulvar> bulvarList = new ArrayList<>();


    public BulvarAdapter(ArrayList<Bulvar> restList) {
        BulvarAdapter.bulvarList = restList;
    }

    @NonNull
    @Override
    public BulvarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bulvar_item, parent, false);
        return new BulvarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BulvarViewHolder holder, int position) {

        Bulvar bulvar = bulvarList.get(position);

        holder.resName.setText(bulvar.name);
        holder.restLocation.setText(bulvar.location);
        holder.tvData.setText(bulvar.data);
        holder.image.setImageResource(bulvar.image);
    }

    @Override
    public int getItemCount() {
        return bulvarList != null ? bulvarList.size() : 0;
    }

    public static class BulvarViewHolder extends RecyclerView.ViewHolder {
        private TextView resName, restLocation, tvData;
        private ImageView image;

        public BulvarViewHolder(@NonNull View itemView) {
            super(itemView);

            resName = itemView.findViewById(R.id.tv_name);
            restLocation = itemView.findViewById(R.id.tv_locat);
            image = itemView.findViewById(R.id.img_restaurant);
            tvData = itemView.findViewById(R.id.tv_data);

        }
    }
}
