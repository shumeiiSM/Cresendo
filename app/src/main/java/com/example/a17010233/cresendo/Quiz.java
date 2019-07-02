package com.example.a17010233.cresendo;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class Quiz extends AppCompatActivity {

    //private Question mQuestion = new Question();
    private Button btnBack;
    private TextView mScoreView;
    private TextView mTiming;
    private TextView mQuestionNum;
    private ImageView mImageView;
    private RadioGroup rbGroup;
    private RadioButton mButtonChoice1;
    private RadioButton mButtonChoice2;
    private RadioButton mButtonChoice3;
    private RadioButton mButtonChoice4;

    private ColorStateList textColorDefaultRb;

    private List<Question_Easy> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question_Easy currentQuestion;

    private int score;
    private boolean answered;


//    private String mAnswer;
//    private int mScore = 0;
//    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBack = findViewById(R.id.back);
        mScoreView = findViewById(R.id.score);
        mTiming = findViewById(R.id.time);
        mQuestionNum = findViewById(R.id.question);
        mImageView = findViewById(R.id.questImage);
        rbGroup = findViewById(R.id.rbGroup);
        mButtonChoice1 = findViewById(R.id.first);
        mButtonChoice2 = findViewById(R.id.second);
        mButtonChoice3 = findViewById(R.id.third);
        mButtonChoice4 = findViewById(R.id.fourth);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Level.class);
                startActivity(intent);
            }
        });



        textColorDefaultRb = mButtonChoice1.getTextColors();

        Helper dbHelper = new Helper(this);
        questionList = dbHelper.getAllQuestions();

        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        if(!answered) {
            if(mButtonChoice1.isChecked() || mButtonChoice2.isChecked() || mButtonChoice3.isChecked() || mButtonChoice4.isChecked()) {
                checkAnswer();
            } else {
                Toast.makeText(Quiz.this, "Please choose 1 answer", Toast.LENGTH_SHORT).show();
            }
        } else {
            showNextQuestion();
        }


//        updateQuestion();
//
//        // Start Button Listener for 1st Button
//        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mButtonChoice1.getText() == mAnswer) {
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//
//                    Button btn1 = findViewById(R.id.firstbtn);
//                    btn1.setTextColor(Color.green(1));
//
//                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();
//
//                } else {
//                    Button btn1 = findViewById(R.id.firstbtn);
//                    btn1.setTextColor(Color.red(1));
//
//                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
//                    updateQuestion();
//                }
//            }
//        });
//
//        // Start Button Listener for 2nd Button
//        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mButtonChoice2.getText() == mAnswer) {
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//
//                    Button btn2 = findViewById(R.id.secondbtn);
//                    btn2.setTextColor(Color.green(1));
//
//                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();
//
//                } else {
//                    Button btn2 = findViewById(R.id.secondbtn);
//                    btn2.setTextColor(Color.red(1));
//
//                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
//                    updateQuestion();
//                }
//            }
//        });
//
//        // Start Button Listener for 3rd Button
//        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mButtonChoice3.getText() == mAnswer) {
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//
//                    Button btn3 = findViewById(R.id.thirdbtn);
//                    btn3.setTextColor(Color.green(1));
//
//                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();
//
//                } else {
//                    Button btn3 = findViewById(R.id.thirdbtn);
//                    btn3.setTextColor(Color.red(1));
//
//                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
//                    updateQuestion();
//                }
//            }
//        });
//
//        // Start Button Listener for 4th Button
//        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mButtonChoice4.getText() == mAnswer) {
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//
//                    Button btn4 = findViewById(R.id.fourthbtn);
//                    btn4.setTextColor(Color.green(1));
//
//                    Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_LONG).show();
//
//                } else {
//                    Button btn4 = findViewById(R.id.fourthbtn);
//                    btn4.setTextColor(Color.red(1));
//
//                    Toast.makeText(Quiz.this, "Wrong!", Toast.LENGTH_LONG).show();
//                    updateQuestion();
//                }
//            }
//        });


    }

    private void showNextQuestion() {
        mButtonChoice1.setTextColor(textColorDefaultRb);
        mButtonChoice2.setTextColor(textColorDefaultRb);
        mButtonChoice3.setTextColor(textColorDefaultRb);
        mButtonChoice4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            Resources res = getResources();
            String qns = currentQuestion.getQuestion();
            int resID = res.getIdentifier(qns , "drawable", getPackageName());
            mImageView.setImageResource(resID);

            mButtonChoice1.setText(currentQuestion.getOpt1());
            mButtonChoice2.setText(currentQuestion.getOpt2());
            mButtonChoice3.setText(currentQuestion.getOpt3());
            mButtonChoice4.setText(currentQuestion.getOpt4());

            questionCounter++;
            mQuestionNum.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
        } else {
            finishQuiz();
        }
    }

    private void checkAnswer() {
        answered = true;
    }

    private void finishQuiz() {
        finish();
    }

//    private void updateQuestion() { ;
//        mImageView.setImageDrawable(mQuestion);
//        mButtonChoice1.setText(mQuestion.getChoice1(mQuestionNumber));
//        mButtonChoice2.setText(mQuestion.getChoice2(mQuestionNumber));
//        mButtonChoice3.setText(mQuestion.getChoice3(mQuestionNumber));
//        mButtonChoice4.setText(mQuestion.getChoice4(mQuestionNumber));
//        mQuestionNumber++;
//
//        mAnswer = mQuestion.getCorrectAnswer(mQuestionNumber);
//    }
//
//    private void updateScore(int point) {
//        mScoreView.setText("" + mScore);
//    }
}
