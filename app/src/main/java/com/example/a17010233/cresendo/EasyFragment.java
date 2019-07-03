package com.example.a17010233.cresendo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class EasyFragment extends Fragment {

    private TextView tv;


    public EasyFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_easy, container, false);

        tv = view.findViewById(R.id.tv);

        return view;
    }

}
