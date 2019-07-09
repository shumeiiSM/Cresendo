package com.example.a17010233.cresendo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdvanceFragment extends Fragment {

    TextView tv;
    ListView lv;
    ArrayList<Score> score;
    ArrayAdapter<Score> aa;

    public AdvanceFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advance, container, false);

        tv = view.findViewById(R.id.tv);
        lv = view.findViewById(R.id.lvadvance);

        score = new ArrayList<Score>();
        score.add(new Score("red", "Thur, 1 Jun 2019", "10:30 AM", 100));
        score.add(new Score("red", "Mon, 20 May 2019", "5:21 PM", 300));
        score.add(new Score("red", "Tue, 9 Jul 2019", "8:26 PM", 500));

        aa = new EasyAdapter(getActivity(), R.layout.leaderboard, score);
        lv.setAdapter(aa);

        return view;
    }

}
