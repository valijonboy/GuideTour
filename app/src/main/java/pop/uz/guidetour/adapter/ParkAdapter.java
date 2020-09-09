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
import pop.uz.guidetour.model.Parks;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ParkViewHolder>{

    public static ArrayList<Parks> parksList = new ArrayList<>();
    public static AdapterListener mListener;

    public ParkAdapter(ArrayList<Parks> parksList, AdapterListener mListener) {
        ParkAdapter.parksList = parksList;
       ParkAdapter.mListener = mListener;
    }

    public interface AdapterListener{
        void itemClicked(int adapterPosition);
    }

    @NonNull
    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.park_item, parent, false);
        return new ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkViewHolder holder, int position) {

        Parks parks = parksList.get(position);

        holder.parkName.setText(parks.name);
        holder.parkLocation.setText(parks.location);
        holder.image.setImageResource(parks.image);



    }

    @Override
    public int getItemCount() {
        return parksList != null ? parksList.size() : 0;
    }



    public static class ParkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView parkName, parkLocation;
        private ImageView image;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);

            parkName = itemView.findViewById(R.id.tv_park_name);
            parkLocation = itemView.findViewById(R.id.tv_park_locat);
            image = itemView.findViewById(R.id.img_park);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.itemClicked(getAdapterPosition());
        }
    }
}
