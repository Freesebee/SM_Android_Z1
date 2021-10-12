package com.example.quiz;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private int id;
    private boolean answer;

    public Question(int id, boolean answer) {
        this.id = id;
        this.answer = answer;
    }
}
