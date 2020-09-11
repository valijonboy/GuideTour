package pop.uz.guidetour.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pop.uz.guidetour.R;
import pop.uz.guidetour.adapter.BulvarAdapter;
import pop.uz.guidetour.model.Bulvar;

public class SretenskyBulvar extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Bulvar> bulvarList;
    private BulvarAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sretensky_bulvar, container, false);
        recyclerView = root.findViewById(R.id.recycler_sretensky);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        addRestrToRestrList();
        adapter = new BulvarAdapter(bulvarList);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecoration);
        return root;
    }

    private void addRestrToRestrList() {

        bulvarList = new ArrayList<>();

        bulvarList.add(new Bulvar("Sretensky Bulvar", "Sretenskiy bulvar, Moskow",
                "Metro Sretenskiy bulvar", R.drawable.sretenskoy_bulvar));
        bulvarList.add(new Bulvar("Cafe Sandal", "Sretenskiy bul., 3",
                "cafesandal.ru", R.drawable.kafe_sandal));
        bulvarList.add(new Bulvar(" Theatre Trikster", "Sretenskiy bul., 6/1s2",
                "trikst.com", R.drawable.teatr_trikster));
        bulvarList.add(new Bulvar("Nailon Studio", "Sretensky bul., 6/1s1",
                "+7(495) 120-18-03", R.drawable.nailon_studio));
    }

}