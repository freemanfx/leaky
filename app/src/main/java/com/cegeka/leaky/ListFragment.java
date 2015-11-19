package com.cegeka.leaky;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater from = LayoutInflater.from(getActivity());
        View view = from.inflate(R.layout.content_main, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new ListAdapter(getActivity()));

        return view;
    }
}
