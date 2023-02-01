package com.skypro.exam_question.service;

import com.skypro.exam_question.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService{

    private List<QuestionService> questionServices;

    private UtilService utilService;

    private Set<Question> examQuestions = new HashSet<>();

    public ExaminerServiceImpl(List<QuestionService> questionService, UtilService utilService) {
        this.questionServices = questionService;
        this.utilService = utilService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <0 || amount > calculateAmountOfQuestionInCollection()) {
            throw new IllegalArgumentException("BAD_REQUEST");
        }

        while (examQuestions.size() < amount) {
            int numberQuestion = utilService.getRandomInt(questionServices.size());
            QuestionService question = questionServices.get(numberQuestion);
            examQuestions.add(question.getRandomQuestion());
        }
        return examQuestions;
    }

    private int calculateAmountOfQuestionInCollection() {
        return questionServices.stream().mapToInt(s -> s.getAll().size()).sum();
    }


}
