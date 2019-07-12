package com.example.a17010233.cresendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EndQuiz extends AppCompatActivity {

    LinearLayout linear;
    TextView tvScore, tvLevel, tvLeader;
    Button btnPlay, btnLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        linear = findViewById(R.id.linear);

        tvLevel = findViewById(R.id.tvLevel);
        tvScore = findViewById(R.id.tvFScore);
        btnPlay = findViewById(R.id.btnPlay);
        btnLevel = findViewById(R.id.btnLevel);
        tvLeader = findViewById(R.id.tvLeader);

        Intent intentReceived = getIntent();
        int score = intentReceived.getIntExtra("fscore",0);
        final String level = intentReceived.getStringExtra("level");
        tvScore.setText(String.valueOf(score));
        tvLevel.setText(level);

        if (level.equalsIgnoreCase("Easy")) {
            linear.setBackgroundResource(R.drawable.green);
            btnPlay.setBackgroundResource(R.drawable.confirm);
            btnLevel.setBackgroundResource(R.drawable.confirm);

        } else if (level.equalsIgnoreCase("Intermediate")) {
            linear.setBackgroundResource(R.drawable.blue);
            btnPlay.setBackgroundResource(R.drawable.confirm_i);
            btnLevel.setBackgroundResource(R.drawable.confirm_i);

        } else if (level.equalsIgnoreCase("Advance")) {
            linear.setBackgroundResource(R.drawable.red);
            btnPlay.setBackgroundResource(R.drawable.confirm_a);
            btnLevel.setBackgroundResource(R.drawable.confirm_a);

        } else {
            linear.setBackgroundResource(R.drawable.black);
            btnPlay.setBackgroundResource(R.drawable.confirm_b);
            btnLevel.setBackgroundResource(R.drawable.confirm_b);
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level.equalsIgnoreCase("Easy")) {
                    Intent intent = new Intent(getBaseContext(),Quiz.class);
                    startActivity(intent);
                } else if (level.equalsIgnoreCase("Intermediate")) {
                    Intent intent = new Intent(getBaseContext(),Intermediate.class);
                    startActivity(intent);
                } else if (level.equalsIgnoreCase("Advance")) {
                    Intent intent = new Intent(getBaseContext(), Advance.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getBaseContext(), Insane.class);
                    startActivity(intent);
                }
            }
        });

        btnLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Level.class);
                startActivity(intent);
            }
        });

        tvLeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Leader.class);
                startActivity(intent);
            }
        });
    }
}
