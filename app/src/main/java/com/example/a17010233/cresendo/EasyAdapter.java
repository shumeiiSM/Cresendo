package com.example.a17010233.cresendo;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class EasyAdapter extends ArrayAdapter<Score> {

    private ArrayList<Score> score;
    private Context context;
    private TextView tvDate, tvTime, tvScore;
    private CircleImageView ivLevel;

    public EasyAdapter(Context context, int resource, ArrayList<Score> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        score = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.leaderboard, parent, false);

        // Get the TextView object
        tvDate = rowView.findViewById(R.id.tvDate);
        tvTime = rowView.findViewById(R.id.tvTime);
        tvScore = rowView.findViewById(R.id.tvScore);
        // Get the ImageView object
        ivLevel = rowView.findViewById(R.id.ivLevel);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Score currentScore = score.get(position);
        // Set the TextView to show the food
        tvDate.setText(currentScore.getDate());
        tvTime.setText(currentScore.getTime());
        tvScore.setText(String.valueOf(currentScore.getScore()));

        if (currentScore.getImageL().equalsIgnoreCase("green")) {
            ivLevel.setImageResource(R.drawable.green);
        } else if (currentScore.getImageL().equalsIgnoreCase("blue")) {
            ivLevel.setImageResource(R.drawable.blue);
        } else if (currentScore.getImageL().equalsIgnoreCase("red")) {
            ivLevel.setImageResource(R.drawable.red);
        } else {
            ivLevel.setImageResource(R.drawable.black);
        }


        // Return the nicely done up View to the ListView
        return rowView;
    }
}
