package com.skypro.exam_question.service;

import com.skypro.exam_question.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    private QuestionService questionService;

    @Mock
    private UtilService utilService;

    @BeforeEach
    public void setUp () {
        out = new ExaminerServiceImpl(List.of(questionService), utilService);
    }

    @Test
    void getQuestionsWithCorrectAmount() {
        Question expected = new Question("Question?", "Answer!");
        Collection<Question> expectedList = Set.of(expected);
        Mockito.when(utilService.getRandomInt(anyInt())).thenReturn(0);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedList);
        Collection<Question> actualList = out.getQuestions(1);
        assertEquals(actualList, expectedList);
    }

    @Test
    void getQuestionWIthIncorrectAmount () {
        Mockito.when(questionService.getAll()).thenReturn(Set.of(new Question("Question", "Answer")));
        assertThrows(IllegalArgumentException.class, () -> out.getQuestions(3));
    }
}