package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button buttonTrue;
    private Button buttonFalse;
    private Button buttonNext;
    private TextView question;

    private Question[] questions = new Question[] {
            new Question(R.string.q_uciski, true),
            new Question(R.string.q_pozycja, true),
            new Question(R.string.q_krwotok, false),
            new Question(R.string.q_topielec, true),
            new Question(R.string.q_cialo, false)
    };

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTrue = findViewById(R.id.button_true);
        buttonFalse = findViewById(R.id.button_false);
        buttonNext = findViewById(R.id.button_next);
        question = findViewById(R.id.question_text_view);

        question.setText(questions[0].getId());

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer( true);
            }
        });

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextQuestion();
            }
        });
    }

    private void checkAnswer(boolean userAnswer) {
        int resultMessageId = 0;

        if (userAnswer == questions[index].isAnswer()) {
            resultMessageId = R.string.answer_correct;
        } else {
            resultMessageId = R.string.answer_wrong;
        }

        Toast.makeText(this, resultMessageId, Toast.LENGTH_LONG).show();
    }

    private void setNextQuestion() {
        question.setText(questions[++index % questions.length].getId());
    }
}