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
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";


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
        Question_Easy q1 = new Question_Easy("treble_a", "A", "B", "C", "D", 0);
        addQuestion(q1);
        Question_Easy q2 = new Question_Easy("treble_b", "A", "B", "C", "D", 1);
        addQuestion(q2);
        Question_Easy q3 = new Question_Easy("treble_c", "A", "B", "C", "D", 2);
        addQuestion(q3);
        Question_Easy q4 = new Question_Easy("treble_d", "A", "B", "C", "D", 3);
        addQuestion(q4);
        Question_Easy q5 = new Question_Easy("treble_e", "E", "B", "C", "D", 0);
        addQuestion(q5);

    }


    private void addQuestion(Question_Easy question_easy) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question_easy.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPT1, question_easy.getOpt1());
        cv.put(QuestionsTable.COLUMN_OPT2, question_easy.getOpt2());
        cv.put(QuestionsTable.COLUMN_OPT3, question_easy.getOpt3());
        cv.put(QuestionsTable.COLUMN_OPT4, question_easy.getOpt4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question_easy.getAnswer());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question_Easy> getAllQuestions() {
        List<Question_Easy> questionList = new ArrayList<>();
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
                questionList.add(question_easy);

            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
