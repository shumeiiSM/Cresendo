package com.example.a17010233.cresendo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class EasyFragment extends Fragment{

    TextView tv;
    ListView lv;
    ArrayList<Score> score;
    ArrayAdapter aa;

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
        lv = view.findViewById(R.id.lveasy);

        score = new ArrayList<Score>();
        score.add(new Score("green", "2018", "1PM", 300));
        score.add(new Score("green", "2019", "12PM", 100));
        score.add(new Score("green", "2017", "5PM", 500));

        Bundle bundle = this.getArguments();
        if (getArguments() != null) {
            int fscore = bundle.getInt("fscore");
            String date = bundle.getString("date");
            String time = bundle.getString("time");

            score.add(new Score("green", time, date, fscore));
        } else {
            Toast.makeText(getActivity(), "Nothing", Toast.LENGTH_LONG).show();
        }

        aa = new EasyAdapter(getActivity(), R.layout.leaderboard, score);
        lv.setAdapter(aa);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_easy);

        //tv = findViewById(R.id.tv);
        //ListView lv = findViewById(R.id.lveasy);

//        score = new ArrayList<Score>();
//
//        Bundle bundle = getArguments();
//        if (getArguments() != null) {
//            int fscore = bundle.getInt("fscore");
//            String date = bundle.getString("date");
//            String time = bundle.getString("time");
//
//            score.add(new Score("green", time, date, fscore));
//            aa = new EasyAdapter(getActivity(), R.layout.leaderboard, score);
//            lv.setAdapter(aa);
//            //aa.notifyDataSetChanged();
//        } else {
//            Toast.makeText(getActivity(), "Nothing", Toast.LENGTH_LONG).show();
//
//        }
    }

//    @Override
//    public void onActivityResult(int requestCode, int
//            resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Only handle when 2nd activity closed normally
//        //  and data contains something
//        if (resultCode == getActivity().RESULT_OK) {
//            if (data != null) {
//                // Get data passed back from quiz activity
//                String time = data.getStringExtra("time");
//                String date = data.getStringExtra("date");
//                int fScore = data.getIntExtra("fScore", 0);
//
//                score.add(new Score("green", time, date, fScore));
//                aa.notifyDataSetChanged();
//            }
//        }
//    }
}
