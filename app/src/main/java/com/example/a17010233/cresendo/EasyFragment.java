package com.example.a17010233.cresendo;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

public class EasyFragment extends Fragment {

    TextView tv;
    ListView lv;
    ArrayList<Score> score;
    ArrayAdapter<Score> aa;

    int escore;
    String edate;
    String etime;

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

//        if (!savedInstanceState.isEmpty()) {
//            escore = savedInstanceState.getInt("escore", 0);
//            edate = savedInstanceState.getString("edate");
//            etime = savedInstanceState.getString("etime");
//        }

        score = new ArrayList<Score>();
        score.add(new Score("green", "Mon, 20 May 2019", "5:21 PM", 300));
        score.add(new Score("green", "Thur, 1 Jun 2019", "10:30 AM", 100));
        score.add(new Score("green", "Tue, 9 Jul 2019", "8:26 PM", 500));

        // Retrieve the saved data from the SharedPreferences object
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            int escore = prefs.getInt("escore", 0);
            String edate = prefs.getString("edate", "no date");
            String etime = prefs.getString("etime", "no time");

            if (escore != 0 && !edate.equals("no date") && !etime.equals("no time")) {
                score.add(new Score("green", edate, etime, escore));
            }

//        if (score.get(score.size() - 1).getScore() != escore && !score.get(score.size() - 1).getDate().equals(edate) && !score.get(score.size() - 1).getTime().equals(etime)) {
//            score.add(new Score("green", edate, etime, escore));
//            aa.notifyDataSetChanged();
//        }


//        Bundle bundle = this.getArguments();
//        if (getArguments() != null) {
//            int escore = bundle.getInt("escore", 0);
//            String edate = bundle.getString("edate");
//            String etime = bundle.getString("etime");
//
//            score = new ArrayList<Score>();
//            score.add(new Score("green", "Mon, 20 May 2019", "5:21 PM", 300));
//            score.add(new Score("green", "Thur, 1 Jun 2019", "10:30 AM", 100));
//            score.add(new Score("green", "Tue, 9 Jul 2019", "8:26 PM", 500));
//            score.add(new Score("green", etime, edate, escore));
//            //aa.notifyDataSetChanged();
//        } else {
//            Toast.makeText(getActivity(), "Nothing", Toast.LENGTH_LONG).show();
//        }


        aa = new EasyAdapter(getActivity(), R.layout.leaderboard, score);
        lv.setAdapter(aa);

        return view;
    }
}

//    @Override
//    public void onResume() {
//        super.onResume();
//        Bundle bundle = this.getArguments();
//        if (getArguments() != null) {
//            int escore = bundle.getInt("escore");
//            String edate = bundle.getString("edate");
//            String etime = bundle.getString("etime");
//
//            score.add(new Score("green", etime, edate, escore));
//            aa.notifyDataSetChanged();
//        } else {
//            Toast.makeText(getActivity(), "Nothing", Toast.LENGTH_LONG).show();
//        }
//    }

//        Bundle bundle = this.getArguments();
//        if (getArguments() != null) {
//            int escore = bundle.getInt("escore", 0);
//            String edate = bundle.getString("edate");
//            String etime = bundle.getString("etime");
//
//            score.add(new Score("green", etime, edate, escore));
//            aa.notifyDataSetChanged();
//        } else {
//            Toast.makeText(getActivity(), "Nothing", Toast.LENGTH_LONG).show();
//        }
//    }


        // Retrieve the saved data from the SharedPreferences object
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
//        int escore = prefs.getInt("escore", 0);
//        String edate = prefs.getString("edate", "no date");
//        String etime = prefs.getString("etime", "no time");
//
//        if (score.get(score.size() - 1).getScore() != escore && !score.get(score.size() - 1).getDate().equals(edate) && !score.get(score.size() - 1).getTime().equals(etime)) {
//            score.add(new Score("green", edate, etime, escore));
//            aa.notifyDataSetChanged();
//        }
//    }
//}

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
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
//    }

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
