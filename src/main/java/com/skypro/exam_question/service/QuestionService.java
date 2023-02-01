package com.skypro.exam_question.service;

import com.skypro.exam_question.model.Question;

import java.util.Collection;

public interface QuestionService {
    public Question add(String question, String answer);
    public Question add(Question question);
    public Collection<Question> getAll();
    public Question remove(Question question);
    public Question getRandomQuestion();
}
