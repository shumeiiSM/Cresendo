package com.example.a17010233.cresendo;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Question extends Drawable {

//    private String mQuestion [] = {
//            "treble_a",
//            "treble_c",
//            "treble_f",
//            "treble_g",
//            "treble_d",
//            "treble_b",
//            "treble_c5",
//            "treble_e"
//    };

    private int mQuestion [] = {
            R.drawable.treble_a,
            R.drawable.treble_c,
            R.drawable.treble_f,
            R.drawable.treble_g,
            R.drawable.treble_d,
            R.drawable.treble_b,
            R.drawable.treble_c5,
            R.drawable.treble_e
    };

    private String mChoice [][] = {
            {"C", "A", "B", "D"},
            {"G", "F", "C", "C5"},
            {"B", "A", "F", "G"},
            {"D", "G", "A", "C"},
            {"F", "E", "C5", "D"},
            {"B", "C", "A", "G"},
            {"G", "E", "C5", "A"},
            {"C", "E", "A", "B"}
    };

    private String mCorrectAnswers[] = {"A","C","F","G","D","B","C5","E"};

    public int getQuestion(int a) {
        int question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoice[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoice[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoice[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoice[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {

    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
