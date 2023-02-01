package com.skypro.exam_question.service;

import com.skypro.exam_question.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
@Service
public class UtilService {
    Random random = new Random();

    public int getRandomInt (int bound) {
        return random.nextInt(bound);
    }
    public Question getRandomQuestion(Collection<Question> questions) {
        int questionNumber = getRandomInt(questions.size());
        int questionCur = 0;
        for (Question question:
             questions) {
            if (questionCur == questionNumber) {
                return question;
            }
            questionCur++;
        }
        return null;
    }
}
