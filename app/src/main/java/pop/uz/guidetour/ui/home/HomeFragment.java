package pop.uz.guidetour.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pop.uz.guidetour.R;
import pop.uz.guidetour.RestaurantsNames;
import pop.uz.guidetour.WebViewActivity;
import pop.uz.guidetour.adapter.RestaurantAdapter;
import pop.uz.guidetour.model.Restaurants;

public class HomeFragment extends Fragment implements RestaurantAdapter.AdapterListener {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private ArrayList<Restaurants> restList;
    private RestaurantAdapter adapter;
    public RestaurantAdapter.AdapterListener listener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
      recyclerView = root.findViewById(R.id.recycler_restaurant);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
      recyclerView.setHasFixedSize(true);

      addRestrToRestrList();
      adapter = new RestaurantAdapter(restList, listener);
      recyclerView.setAdapter(adapter);


        return root;
    }

    private void addRestrToRestrList(){

        restList = new ArrayList<>();

        restList.add(new Restaurants("Budvar", "Kotelnicheskaya Emb., 33 M. Taganskaya", R.drawable.ic_map));
        restList.add(new Restaurants("Mr. Som", "Vernadskogo ave., 6, Moscow 119311 Russia", R.drawable.ic_map));
        restList.add(new Restaurants("Juicy Lab", "Mytnaya St., 74, Moscow 115191 Russia", R.drawable.ic_map));
        restList.add(new Restaurants("Brooklyn BBQ", "Ladozhskaya St., 5, Moscow 105005 Russia", R.drawable.ic_map));
        restList.add(new Restaurants("Jimmy Poy", "Lubyanskiy Dr, 15, Moscow 101000 Russia", R.drawable.ic_map));
        restList.add(new Restaurants("Mimino", "Domodedovskaya St., 24/3 Ground floor, Moscow ", R.drawable.ic_map));
    }

    @Override
    public void itemClicked(int adapterPosition) {

        switch (adapterPosition){
            case 0:
               startWebViewActivity(RestaurantsNames.REST1);
               break;
            case 1:
                startWebViewActivity(RestaurantsNames.REST2);
                break;
            case 2:
                startWebViewActivity(RestaurantsNames.REST3);
                break;
            case 3:
                startWebViewActivity(RestaurantsNames.REST4);
                break;
            case 4:
                startWebViewActivity(RestaurantsNames.REST5);
                break;
            case 5:
                startWebViewActivity(RestaurantsNames.REST6);
                break;

            default:
                break;
        }

    }

    private void startWebViewActivity(RestaurantsNames names) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra(WebViewActivity.INTENT_RESTR_NAME, names);
        startActivity(intent);
    }
}