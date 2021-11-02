package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String QUIZ_TAG = "MainActivity";
    private static final String KEY_CURRENT_INDEX = "currentIndex";
    public static final String KEY_EXTRA_ANSWER = "correctAnswer";

    private Button buttonTrue;
    private Button buttonFalse;
    private Button buttonNext;
    private Button buttonHint;

    private TextView question;

    private final Question[] questions = new Question[] {
            new Question(R.string.q_uciski, true),
            new Question(R.string.q_pozycja, true),
            new Question(R.string.q_krwotok, false),
            new Question(R.string.q_topielec, true),
            new Question(R.string.q_cialo, false)
    };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.d(QUIZ_TAG, "Została wywołana metoda cyklu życia: onCreate");

        setContentView(R.layout.activity_main);

        buttonTrue = findViewById(R.id.button_true);
        buttonFalse = findViewById(R.id.button_false);
        buttonNext = findViewById(R.id.button_next);
        buttonHint = findViewById(R.id.button_hint);
        question = findViewById(R.id.question_text_view);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX);
        } else {
            currentIndex = 0;
        }

        question.setText(questions[currentIndex].getId());

        buttonTrue.setOnClickListener(v -> checkAnswer( true));

        buttonFalse.setOnClickListener(v -> checkAnswer(false));

        buttonNext.setOnClickListener(v -> setNextQuestion());

        buttonHint.setOnClickListener((v) -> {
            Intent intent = new Intent(MainActivity.this, PromptActivity.class);
            boolean correctAnswer = questions[currentIndex].isAnswer();
            intent.putExtra(KEY_EXTRA_ANSWER, correctAnswer);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(QUIZ_TAG, "Została wywołana metoda cyklu życia: onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(QUIZ_TAG, "Została wywołana metoda cyklu życia: onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(QUIZ_TAG, "Została wywołana metoda cyklu życia: onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(QUIZ_TAG, "Została wywołana metoda cyklu życia: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(QUIZ_TAG, "Została wywołana metoda cyklu życia: onDestroy");
    }

    private void checkAnswer(boolean userAnswer) {

        if (userAnswer == questions[currentIndex].isAnswer()) {
            Toast.makeText(this, "Poprawna odpowiedź!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.answer_wrong, Toast.LENGTH_LONG).show();
        }
    }

    private void setNextQuestion() {
        question.setText(questions[++currentIndex % questions.length].getId());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(QUIZ_TAG, "Została wywołana metoda: onSaveInstanceState");
        outState.putInt(KEY_CURRENT_INDEX, currentIndex);
    }
}