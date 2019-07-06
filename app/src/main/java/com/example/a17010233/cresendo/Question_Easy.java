package com.example.a17010233.cresendo;

public class Question_Easy {
    public static final String DIFFICULTY_EASY = "Easy";
    public static final String DIFFICULTY_INTERMEDIATE = "Intermediate";
    public static final String DIFFICULTY_ADVANCE = "Advance";
    public static final String DIFFICULTY_INSANE = "Insane";

    private String question;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private int answer;
    private String sound;
    private String difficulty;

    public Question_Easy() {}

    public Question_Easy(String question, String opt1, String opt2, String opt3, String opt4, int answer, String sound, String difficulty) {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.answer = answer;
        this.sound = sound;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static String[] getAllDifficultyLevels() {
        return new String[]{
                DIFFICULTY_EASY,
                DIFFICULTY_INTERMEDIATE,
                DIFFICULTY_ADVANCE,
                DIFFICULTY_INSANE
        };
    }

}
