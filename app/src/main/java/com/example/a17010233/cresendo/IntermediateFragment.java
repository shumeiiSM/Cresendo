package com.example.a17010233.cresendo;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class IntermediateFragment extends Fragment {

    TextView tv;
    ListView lv;
    ArrayList<Score> score;
    ArrayAdapter<Score> aa;

    public IntermediateFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intermediate, container, false);

        tv = view.findViewById(R.id.tv);
        lv = view.findViewById(R.id.lvinter);

        score = new ArrayList<Score>();
        score.add(new Score("blue", "Thur, 1 Jun 2019", "10:30 AM", 100));

        // Retrieve the saved data from the SharedPreferences object
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            int iscore = prefs.getInt("iscore", 0);
            String idate = prefs.getString("idate", "no date");
            String itime = prefs.getString("itime", "no time");

        if (iscore != 0 && !idate.equals("no date") && !itime.equals("no time")) {
            score.add(new Score("blue", idate, itime, iscore));
        }


        aa = new EasyAdapter(getActivity(), R.layout.leaderboard, score);
        lv.setAdapter(aa);

        return view;
    }

}
