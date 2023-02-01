package com.skypro.exam_question.repository;

import com.skypro.exam_question.model.Question;
import com.skypro.exam_question.service.QuestionService;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init (){
        questions.add(new Question("question 1" ,"answer 1" ));
        questions.add(new Question("question 2" ,"answer 2" ));
        questions.add(new Question("question 3" ,"answer 3" ));
        questions.add(new Question("question 4" ,"answer 4" ));
        questions.add(new Question("question 5" ,"answer 5" ));
        questions.add(new Question("question 6" ,"answer 6" ));
        questions.add(new Question("question 7" ,"answer 7" ));

    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Введите данные");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new IllegalArgumentException("Вопрос не найден");
        }
        questions.remove(question);
        return question;
    }
}
