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

        bulvarList.add(new Bulvar(getString(R.string.sretenskiy_bulvar), getString(R.string.loc_sretbul),
                getString(R.string.data_sretbul), R.drawable.sretenskoy_bulvar));
        bulvarList.add(new Bulvar(getString(R.string.cafe_sandal), getString(R.string.loc_cafe_sandal),
                getString(R.string.data_cafe_sandal), R.drawable.kafe_sandal));
        bulvarList.add(new Bulvar(getString(R.string.trikster), getString(R.string.loc_trikster),
                getString(R.string.data_trikster), R.drawable.teatr_trikster));
        bulvarList.add(new Bulvar(getString(R.string.nailon), getString(R.string.loc_nailon),
                getString(R.string.data_nailon), R.drawable.nailon_studio));
    }

}