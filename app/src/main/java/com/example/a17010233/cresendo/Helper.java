package com.example.a17010233.cresendo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a17010233.cresendo.EasyContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Cresendo.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String createdTableSql = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + "(" +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                QuestionsTable.COLUMN_QUESTION + " TEXT," +
                QuestionsTable.COLUMN_OPT1 + " TEXT," +
                QuestionsTable.COLUMN_OPT2 + " TEXT," +
                QuestionsTable.COLUMN_OPT3 + " TEXT," +
                QuestionsTable.COLUMN_OPT4 + " TEXT," +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER," +
                QuestionsTable.COLUMN_SOUND + " TEXT," +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT)";


        db.execSQL(createdTableSql);
        fillQuestionsTable();
        Log.i("info", "created tables");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question_Easy q1 = new Question_Easy("treble_a", "A", "B", "C", "D", 0, "option1", Question_Easy.DIFFICULTY_EASY);
        addQuestion(q1);
        Question_Easy q2 = new Question_Easy("treble_b", "A", "B", "C", "D", 1, "option2", Question_Easy.DIFFICULTY_EASY);
        addQuestion(q2);
        Question_Easy q3 = new Question_Easy("treble_c", "A", "B", "C", "D", 2, "option3", Question_Easy.DIFFICULTY_EASY);
        addQuestion(q3);
        Question_Easy q4 = new Question_Easy("treble_d", "A", "B", "C", "D", 3, "option4", Question_Easy.DIFFICULTY_EASY);
        addQuestion(q4);
        Question_Easy q5 = new Question_Easy("treble_e", "E", "B", "C", "D", 0, "option5", Question_Easy.DIFFICULTY_EASY);
        addQuestion(q5);

        Question_Easy q6 = new Question_Easy("bass_a", "BA", "B", "C", "D", 0, "option1", Question_Easy.DIFFICULTY_INTERMEDIATE);
        addQuestion(q6);
        Question_Easy q7 = new Question_Easy("bass_b", "A", "BB", "C", "D", 1, "option2", Question_Easy.DIFFICULTY_INTERMEDIATE);
        addQuestion(q7);
        Question_Easy q8 = new Question_Easy("bass_c", "A", "B", "BC", "D", 2, "option3", Question_Easy.DIFFICULTY_INTERMEDIATE);
        addQuestion(q8);

        Question_Easy q9 = new Question_Easy("sharp_b_a", "A+", "B", "C", "D", 0, "option1", Question_Easy.DIFFICULTY_ADVANCE);
        addQuestion(q9);
        Question_Easy q10 = new Question_Easy("sharp_b_f", "A", "F", "C", "D", 1, "option2", Question_Easy.DIFFICULTY_ADVANCE);
        addQuestion(q10);


        Question_Easy q11 = new Question_Easy("coda", "CODA", "B", "C", "D", 0, "option1", Question_Easy.DIFFICULTY_INSANE);
        addQuestion(q11);
        Question_Easy q12 = new Question_Easy("fermata", "A", "FERMATA", "C", "D", 1, "option2", Question_Easy.DIFFICULTY_INSANE);
        addQuestion(q12);
        Question_Easy q13 = new Question_Easy("half_note", "A+", "B", "HALF NOTE", "D", 2, "option1", Question_Easy.DIFFICULTY_INSANE);
        addQuestion(q13);
        Question_Easy q14 = new Question_Easy("accelerando", "A", "F", "C", "ACCELERANDO", 3, "option2", Question_Easy.DIFFICULTY_INSANE);
        addQuestion(q14);


    }


    private void addQuestion(Question_Easy question_easy) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question_easy.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPT1, question_easy.getOpt1());
        cv.put(QuestionsTable.COLUMN_OPT2, question_easy.getOpt2());
        cv.put(QuestionsTable.COLUMN_OPT3, question_easy.getOpt3());
        cv.put(QuestionsTable.COLUMN_OPT4, question_easy.getOpt4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question_easy.getAnswer());
        cv.put(QuestionsTable.COLUMN_SOUND, question_easy.getSound());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question_easy.getDifficulty());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question_Easy> getAllQuestions() {
        ArrayList<Question_Easy> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question_Easy question_easy = new Question_Easy();
                question_easy.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question_easy.setOpt1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT1)));
                question_easy.setOpt2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT2)));
                question_easy.setOpt3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT3)));
                question_easy.setOpt4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT4)));
                question_easy.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question_easy.setSound(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_SOUND)));
                question_easy.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question_easy);

            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question_Easy> getQuestions(String difficulty) {
        ArrayList<Question_Easy> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question_Easy question_easy = new Question_Easy();
                question_easy.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question_easy.setOpt1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT1)));
                question_easy.setOpt2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT2)));
                question_easy.setOpt3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT3)));
                question_easy.setOpt4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPT4)));
                question_easy.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question_easy.setSound(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_SOUND)));
                question_easy.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question_easy);

            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
