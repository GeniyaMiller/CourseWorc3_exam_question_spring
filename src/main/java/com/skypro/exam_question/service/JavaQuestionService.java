package com.skypro.exam_question.service;

import com.skypro.exam_question.model.Question;
import com.skypro.exam_question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class JavaQuestionService implements QuestionService{

    private final QuestionRepository questionRepository;

    private final UtilService utilService;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository, UtilService utilService) {
        this.questionRepository = questionRepository;
        this.utilService = utilService;
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || question.isBlank() || question.isEmpty()) {
            throw new IllegalArgumentException("Заполните поле");
        }
        if (answer == null || answer.isBlank() || answer.isEmpty()) {
            throw new IllegalArgumentException("Заполните поле");
        }
        return questionRepository.add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Question getRandomQuestion() {
        return utilService.getRandomQuestion(questionRepository.getAll());
    }
}
