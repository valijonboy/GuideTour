package pop.uz.guidetour.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

import pop.uz.guidetour.R;
import pop.uz.guidetour.adapter.BulvarAdapter;
import pop.uz.guidetour.model.Bulvar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetrovskiyBulvar} factory method to
 * create an instance of this fragment.
 */
public class PetrovskiyBulvar extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Bulvar> bulvarList;
    private BulvarAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_petrovskiy_bulvar, container, false);
        recyclerView = root.findViewById(R.id.recycler_petrovsky);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        addItemsToBulvarList();
        adapter = new BulvarAdapter(bulvarList);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecoration);

        return root;
    }

    private void addItemsToBulvarList() {

        bulvarList = new ArrayList<>();

        bulvarList.add(new Bulvar("Petrovskiy bulvar", "Petrovskiy bud., Moskow",
                "Metro Trubnaya", R.drawable.petrovskiy_bulvar));
        bulvarList.add(new Bulvar("BRANDSHOP", "Petrovskiy bud., 21",
                "brandshop.ru", R.drawable.brandshop));
        bulvarList.add(new Bulvar("Church Bogolyubovskoy ikoni", "28 Petrovka street",
                "M. Trubnaya 580 m.", R.drawable.bogolyubovskiy_ikoni));
        bulvarList.add(new Bulvar("AllTime.ru", "Petrovskiy bud., 21",
                "alltime.ru", R.drawable.alltime_ru));


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                FragmentManager fm = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                    return true;
                }
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}