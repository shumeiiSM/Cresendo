package com.example.a17010233.cresendo;

public class Score {
    private String imageL;
    private String date;
    private String time;
    private int score;

    public Score(String imageL, String date, String time, int score) {
        this.imageL = imageL;
        this.date = date;
        this.time = time;
        this.score = score;
    }

    public String getImageL() {
        return imageL;
    }

    public void setImageL(String imageL) {
        this.imageL = imageL;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
