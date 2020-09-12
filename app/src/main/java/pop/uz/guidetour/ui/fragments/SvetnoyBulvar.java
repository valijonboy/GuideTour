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

public class SvetnoyBulvar extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Bulvar> bulvarList;
    private BulvarAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_svetnoy_bulvar, container, false);
        recyclerView = root.findViewById(R.id.recycler_svetnoy);
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

        bulvarList.add(new Bulvar(getString(R.string.svetnoy_bulvar), getString(R.string.loc_svetbulvd),
                getString(R.string.data_svetbulvd), R.drawable.svetnoy_bulvar));
        bulvarList.add(new Bulvar(getString(R.string.sirk), getString(R.string.loc_sirk),
                getString(R.string.data_sirk), R.drawable.sirk_nikulin));
        bulvarList.add(new Bulvar(getString(R.string.chaihona), getString(R.string.loc_chaihona),
                getString(R.string.data_chaihona), R.drawable.chaihona_n1));
        bulvarList.add(new Bulvar(getString(R.string.rinok), getString(R.string.loc_rinok),
                getString(R.string.data_rinok), R.drawable.sentralny_rinok));


    }
}