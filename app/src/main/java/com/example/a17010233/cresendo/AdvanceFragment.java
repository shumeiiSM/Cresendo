package com.example.a17010233.cresendo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class AdvanceFragment extends Fragment {


    public AdvanceFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advance, container, false);

        return view;
    }

}
