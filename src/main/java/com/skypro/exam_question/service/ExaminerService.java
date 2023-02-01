package com.skypro.exam_question.service;

import com.skypro.exam_question.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
