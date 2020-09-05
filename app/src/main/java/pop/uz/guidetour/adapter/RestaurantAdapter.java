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
import pop.uz.guidetour.model.Restaurants;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{

    public ArrayList restList;
    public static AdapterListener mListener;

    public RestaurantAdapter(ArrayList restList, AdapterListener mListener) {
        this.restList = restList;
        RestaurantAdapter.mListener = mListener;
    }

    public interface AdapterListener{
        void itemClicked(int adapterPosition);
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {

        Restaurants restaurants = (Restaurants) restList.get(position);

        holder.resName.setText(restaurants.name);
        holder.restLocation.setText(restaurants.location);
        holder.image.setImageResource(restaurants.image);


    }

    @Override
    public int getItemCount() {
        return restList != null ? restList.size() : 0;
    }



    public static class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView resName, restLocation;
        private ImageView image;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            resName = itemView.findViewById(R.id.tv_restaur_name);
            restLocation = itemView.findViewById(R.id.tv_restaur_locat);
            image = itemView.findViewById(R.id.img_restaurant);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.itemClicked(getAdapterPosition());
        }
    }
}
