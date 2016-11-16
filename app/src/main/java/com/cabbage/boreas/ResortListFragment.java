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

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ResortListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ResortListFragment newInstance(int columnCount) {
        ResortListFragment fragment = new ResortListFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resort_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
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
        } else if (action.equals("long")){
            Toast.makeText(getContext(), String.format(Locale.CANADA, "%s long clicked", resort.displayName), Toast.LENGTH_LONG).show();
        }
    }
}
