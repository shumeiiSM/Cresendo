package com.example.a17010233.cresendo;

import android.provider.BaseColumns;

public final class EasyContract {

    private EasyContract() {}

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPT1 = "opt1";
        public static final String COLUMN_OPT2 = "opt2";
        public static final String COLUMN_OPT3 = "opt3";
        public static final String COLUMN_OPT4 = "opt4";
        public static final String COLUMN_ANSWER_NR = "answer";
        public static final String COLUMN_SOUND = "sound";


    }

}
