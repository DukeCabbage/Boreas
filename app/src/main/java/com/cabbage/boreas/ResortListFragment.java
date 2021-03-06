package com.cabbage.boreas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cabbage.boreas.model.Resort;

import java.util.Locale;


public class ResortListFragment extends Fragment
        implements ResortRecyclerViewAdapter.ItemActionCallback {

    public ResortListFragment() {
    }

    public static ResortListFragment newInstance(int columnCount) {
        return new ResortListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resort_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ResortRecyclerViewAdapter(Resort.dummies, this));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void action(Resort resort, String action) {
        if (action.equals("short")) {
            Toast.makeText(getContext(), String.format(Locale.CANADA, "%s clicked", resort.displayName), Toast.LENGTH_LONG).show();
        } else if (action.equals("long")) {
            Toast.makeText(getContext(), String.format(Locale.CANADA, "%s long clicked", resort.displayName), Toast.LENGTH_LONG).show();
        }
    }
}
