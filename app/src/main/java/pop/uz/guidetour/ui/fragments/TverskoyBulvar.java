package pop.uz.guidetour.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pop.uz.guidetour.R;
import pop.uz.guidetour.adapter.BulvarAdapter;
import pop.uz.guidetour.model.Bulvar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TverskoyBulvar#} factory method to
 * create an instance of this fragment.
 */
public class TverskoyBulvar extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Bulvar> bulvarList;
    private BulvarAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tverskoy_bulvar, container, false);
        recyclerView = root.findViewById(R.id.recycler_tverskoy);
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

        bulvarList.add(new Bulvar(getString(R.string.tverskoy_bulvar), getString(R.string.loc_tverskoy),
                getString(R.string.data_tverskoy), R.drawable.tverskoy_bulvar));
        bulvarList.add(new Bulvar(getString(R.string.teatr_pushkin), getString(R.string.loc_pushkin),
                getString(R.string.data_teatr_pushkin), R.drawable.teatr_pushkin));
        bulvarList.add(new Bulvar(getString(R.string.remy_kitch), getString(R.string.loc_remykitch),
                getString(R.string.data_remykitch), R.drawable.remy_kitchenbakery));
        bulvarList.add(new Bulvar(getString(R.string.mxat_gork), getString(R.string.loc_mxat),
                getString(R.string.data_mxat), R.drawable.mxat_teatr));


    }
}