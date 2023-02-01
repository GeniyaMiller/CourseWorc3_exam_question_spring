package com.skypro.exam_question.repository;

import com.skypro.exam_question.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Collection<Question> getAll();
    Question remove(Question question);
}
