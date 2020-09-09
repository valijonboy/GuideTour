package pop.uz.guidetour.ui.parks;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pop.uz.guidetour.R;
import pop.uz.guidetour.adapter.ParkAdapter;
import pop.uz.guidetour.enumnames.ParkNames;
import pop.uz.guidetour.model.Parks;
import pop.uz.guidetour.webviewactivity.WebViewParkActivity;


public class ParkFragment extends Fragment implements ParkAdapter.AdapterListener {

    public static final String INTENT_PARK = "intent_park";

    private RecyclerView recyclerView;
    private ArrayList<Parks> parksList;
    private ParkAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_park, container, false);
        recyclerView = root.findViewById(R.id.recycler_parks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        addParksToParkList();
        adapter = new ParkAdapter(parksList, this);
        recyclerView.setAdapter(adapter);


        return root;
    }

    private void addParksToParkList(){

        parksList = new ArrayList<>();

        parksList.add(new Parks("Victory Park", "Bratyev Fonchenko st., 7", R.drawable.ic_map));
        parksList.add(new Parks("Sokolniki Park", "Sokol'nicheskiy Val, 1/1", R.drawable.ic_map));
        parksList.add(new Parks("Muzeon Art Park", "Krymskiy Val, 2", R.drawable.ic_map));
        parksList.add(new Parks("Park Zaryadye",
                "Varvarka, 6/1", R.drawable.ic_map));
        parksList.add(new Parks("Neskuchny sad", "Leninskiy Avenue, 32a Metro Oktyabrskaya", R.drawable.ic_map));
        parksList.add(new Parks("Aleksandrovskiy Sad", "Near Kremlin, Moscow", R.drawable.ic_map));

    }

    @Override
    public void itemClicked(int adapterPosition) {

        switch (adapterPosition){
            case 0:
                startWebViewActivity(ParkNames.PARK1);
                break;
            case 1:
                startWebViewActivity(ParkNames.PARK2);
                break;
            case 2:
                startWebViewActivity(ParkNames.PARK3);
                break;
            case 3:
                startWebViewActivity(ParkNames.PARK4);
                break;
            case 4:
                startWebViewActivity(ParkNames.PARK5);
                break;
            case 5:
                startWebViewActivity(ParkNames.PARK6);
                break;

            default:
                break;
        }

    }

    private void startWebViewActivity(ParkNames names) {
        Intent intent = new Intent(getActivity(), WebViewParkActivity.class);
        intent.putExtra(WebViewParkActivity.INTENT_PARK_NAME, names);
        startActivity(intent);
    }
}