package com.example.schoolvoice_test.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolvoice_test.R;
import com.example.schoolvoice_test.adapter.CustomAdapter;
import com.example.schoolvoice_test.model.DbOperations;
import com.example.schoolvoice_test.model.Actions;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewsFragment extends Fragment {

    DbOperations dbOperations;

    public ViewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_views, container, false);

        // db operation handler
        dbOperations = new DbOperations();
        List<Actions> actionList = dbOperations.getViewsList(getActivity());

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rv_views);
        CustomAdapter mAdapter = new CustomAdapter(getActivity(),actionList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

       dbOperations.releaseDb();
    }

}
