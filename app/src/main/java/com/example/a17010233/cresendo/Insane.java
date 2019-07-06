package com.example.a17010233.cresendo;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
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

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Insane extends AppCompatActivity {
    private static final long COUNTDOWN_IN_MILIS = 10000;

    private TextView tvLevel;

    private Button btnBack;
    private Button btnConfirm;
    private TextView mScoreView;
    private TextView mTiming;
    private TextView mQuestionNum;
    private ImageView mImageView;
    private RadioGroup rbGroup;
    private RadioButton mButtonChoice1;
    private RadioButton mButtonChoice2;
    private RadioButton mButtonChoice3;
    private RadioButton mButtonChoice4;
    private ImageView sound;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilis;

    private List<Question_Easy> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question_Easy currentQuestion;

    private int myscore;
    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insane);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tvLevel = findViewById(R.id.level);

        btnBack = findViewById(R.id.back);
        btnConfirm = findViewById(R.id.btnConfirm);
        mScoreView = findViewById(R.id.score);
        mTiming = findViewById(R.id.time);
        mQuestionNum = findViewById(R.id.question);
        mImageView = findViewById(R.id.questImage);
        rbGroup = findViewById(R.id.rbGroup);
        mButtonChoice1 = findViewById(R.id.first);
        mButtonChoice2 = findViewById(R.id.second);
        mButtonChoice3 = findViewById(R.id.third);
        mButtonChoice4 = findViewById(R.id.fourth);
        sound = findViewById(R.id.sound);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Level.class);
                startActivity(intent);
            }
        });


        textColorDefaultRb = mButtonChoice1.getTextColors();
        textColorDefaultCd = mTiming.getTextColors();

        Helper dbHelper = new Helper(this);
        questionList = dbHelper.getQuestions("Insane");

        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered) {
                    if(mButtonChoice1.isChecked() || mButtonChoice2.isChecked() || mButtonChoice3.isChecked() || mButtonChoice4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(Insane.this, "Please choose 1 answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });

    }

    private void showNextQuestion() {
        mButtonChoice1.setTextColor(textColorDefaultRb);
        mButtonChoice2.setTextColor(textColorDefaultRb);
        mButtonChoice3.setTextColor(textColorDefaultRb);
        mButtonChoice4.setTextColor(textColorDefaultRb);
        //rbGroup.clearCheck();
        mButtonChoice1.setChecked(false);
        mButtonChoice2.setChecked(false);
        mButtonChoice3.setChecked(false);
        mButtonChoice4.setChecked(false);


        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            Resources res = getResources();
            String qns = currentQuestion.getQuestion();
            final int resID = res.getIdentifier(qns , "drawable", getPackageName());
            mImageView.setImageResource(resID);

            mButtonChoice1.setText(currentQuestion.getOpt1());
            mButtonChoice2.setText(currentQuestion.getOpt2());
            mButtonChoice3.setText(currentQuestion.getOpt3());
            mButtonChoice4.setText(currentQuestion.getOpt4());

            sound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = getApplicationContext();
                    int resId = getResources().getIdentifier(currentQuestion.getSound(), "raw", context.getPackageName());

                    final MediaPlayer van = MediaPlayer.create(getApplicationContext(), resId);
                    van.start();
                }
            });

            questionCounter++;
            mQuestionNum.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            btnConfirm.setText("Confirm");

            timeLeftInMilis = COUNTDOWN_IN_MILIS;
            startCountDown();

        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMilis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMilis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int mins = (int) (timeLeftInMilis / 1000) / 60;
        int secs = (int) (timeLeftInMilis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", mins, secs);

        mTiming.setText(timeFormatted);

        if (timeLeftInMilis <= 3000) {
            mTiming.setTextColor(Color.RED);
        } else if (timeLeftInMilis <= 5000) {
            mTiming.setTextColor(Color.YELLOW);
        } else {
            mTiming.setTextColor(textColorDefaultCd);
        }
    }

    private void checkAnswer() {
        answered = true;

        countDownTimer.cancel();

        mScoreView = findViewById(R.id.score);

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected);
        int a = currentQuestion.getAnswer();

        if (answerNr == currentQuestion.getAnswer()) {
            myscore = myscore + 100;
            mScoreView.setText(String.valueOf(myscore));
        }

        showSolution();

    }

    private void showSolution() {
        mButtonChoice1.setTextColor(Color.RED);
        mButtonChoice2.setTextColor(Color.RED);
        mButtonChoice3.setTextColor(Color.RED);
        mButtonChoice4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswer()) {
            case 0:
                mButtonChoice1.setTextColor(Color.GREEN);
                break;
            case 1:
                mButtonChoice2.setTextColor(Color.GREEN);
                break;
            case 2:
                mButtonChoice3.setTextColor(Color.GREEN);
                break;
            case 3:
                mButtonChoice4.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounter < questionCountTotal) {
            btnConfirm.setText("Next");
        } else {
            btnConfirm.setText("Finish");
        }
    }

    private void finishQuiz() {
        SimpleDateFormat date = new SimpleDateFormat("EEE, d MMM yyyy");
        SimpleDateFormat time = new SimpleDateFormat("h:mm a");
        String cDate = date.format(new Date());
        String cTime = time.format(new Date());

        Bundle bundle = new Bundle();
        bundle.putInt("fscore", myscore);
        bundle.putString("date", cDate);
        bundle.putString("time", cTime);
        // set MyFragment Arguments
        EasyFragment myObj = new EasyFragment();
        myObj.setArguments(bundle);

        Intent i = new Intent(getApplicationContext(), EndQuiz.class);
        String myLevel = tvLevel.getText().toString();
        i.putExtra("fscore", myscore);
        i.putExtra("level", myLevel);

        //setResult(RESULT_OK, i);
        //finish();

        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
