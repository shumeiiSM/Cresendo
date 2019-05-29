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

public class Quiz extends AppCompatActivity {

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
        setContentView(R.layout.activity_quiz);

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
        mButtonChoice1 = (Button) findViewById(R.id.firstbtn);
        mButtonChoice2 = (Button) findViewById(R.id.secondbtn);
        mButtonChoice3 = (Button) findViewById(R.id.thirdbtn);
        mButtonChoice4 = (Button) findViewById(R.id.fourthbtn);

        updateQuestion();

        // Start Button Listener for 1st Button
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Button btn1 = findViewById(R.id.firstbtn);
                    btn1.setTextColor(Color.green(1));

                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();

                } else {
                    Button btn1 = findViewById(R.id.firstbtn);
                    btn1.setTextColor(Color.red(1));

                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });

        // Start Button Listener for 2nd Button
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Button btn2 = findViewById(R.id.secondbtn);
                    btn2.setTextColor(Color.green(1));

                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();

                } else {
                    Button btn2 = findViewById(R.id.secondbtn);
                    btn2.setTextColor(Color.red(1));

                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });

        // Start Button Listener for 3rd Button
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Button btn3 = findViewById(R.id.thirdbtn);
                    btn3.setTextColor(Color.green(1));

                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();

                } else {
                    Button btn3 = findViewById(R.id.thirdbtn);
                    btn3.setTextColor(Color.red(1));

                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });

        // Start Button Listener for 4th Button
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice4.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Button btn4 = findViewById(R.id.fourthbtn);
                    btn4.setTextColor(Color.green(1));

                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();

                } else {
                    Button btn4 = findViewById(R.id.fourthbtn);
                    btn4.setTextColor(Color.red(1));

                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });


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
