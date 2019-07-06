package com.example.a17010233.cresendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class EndEQuiz extends AppCompatActivity {

    TextView tvScore;
    Button btnPlay, btnLevel, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_e_quiz);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tvScore = findViewById(R.id.tvFScore);
        btnPlay = findViewById(R.id.btnPlay);
        btnLevel = findViewById(R.id.btnLevel);
        btn = findViewById(R.id.button3);

        Intent intentReceived = getIntent();
        int score = intentReceived.getIntExtra("fscore",0);
        tvScore.setText(String.valueOf(score));

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Quiz.class);
                startActivity(intent);
            }
        });

        btnLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Level.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Leader.class);
                startActivity(intent);
            }
        });
    }
}
