package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    private boolean correctAnswer;
    private Button showCorrectAnswerButton;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);

        showCorrectAnswerButton = findViewById(R.id.button_show_answer);
        answerTextView = findViewById(R.id.q_show_answer);

        showCorrectAnswerButton.setOnClickListener(v -> {
            int answer = correctAnswer ? R.string.button_true : R.string.button_false;
            answerTextView.setText(answer);
        });
    }

}