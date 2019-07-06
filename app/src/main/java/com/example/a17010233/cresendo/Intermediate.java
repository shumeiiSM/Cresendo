package com.example.a17010233.cresendo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Intermediate extends AppCompatActivity {

    private Question mQuestion = new Question();

    private TextView mScoreView;
    private ImageView mImageView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        btnBack = findViewById(R.id.back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Level.class);
                startActivity(intent);
            }
        });


        mScoreView = (TextView) findViewById(R.id.score);
        mImageView = (ImageView) findViewById(R.id.questImage);


    }

    private void updateQuestion() { ;
        mImageView.setImageDrawable(mQuestion);
        mButtonChoice1.setText(mQuestion.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestion.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestion.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuestion.getChoice4(mQuestionNumber));
        mQuestionNumber++;

        mAnswer = mQuestion.getCorrectAnswer(mQuestionNumber);
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
