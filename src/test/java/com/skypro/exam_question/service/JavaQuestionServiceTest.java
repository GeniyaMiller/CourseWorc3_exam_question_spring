package com.skypro.exam_question.service;

import com.skypro.exam_question.model.Question;
import com.skypro.exam_question.repository.QuestionRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @InjectMocks
    private JavaQuestionService out;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private UtilService utilService;

    @BeforeEach
    private void setUp () {
        out = new JavaQuestionService(questionRepository, utilService);
    }

    @Test
    void addQuestionAndAnswer() {
        Question expected = new Question("Question?", "Answer!");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected.getQuestion(), expected.getAnswer());
        assertEquals(expected,actual);
    }

    @Test
    void addQuestion() {
        Question expected = new Question("Question?", "Answer!");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected);
        assertEquals(expected,actual);
    }

    @Test
    void addNullQuestion () {
        assertThrows(IllegalArgumentException.class, () -> out.add(null, "Answer"));
    }

    @Test
    void addNullAnswer () {
        assertThrows(IllegalArgumentException.class, () -> out.add("Question", null));
    }

    @Test
    void addBlankQuestion () {
        assertThrows(IllegalArgumentException.class, () -> out.add("", "Answer"));
    }

    @Test
    void addBlankAnswer () {
        assertThrows(IllegalArgumentException.class, () -> out.add("Question", ""));
    }

    @Test
    void getAllQuestion() {
        Collection<Question> expected = List.of(new Question("Question","Answer"));
        Mockito.when(questionRepository.getAll()).thenReturn(expected);
        Collection<Question> actual = out.getAll();
        assertEquals(expected,actual);
    }

    @Test
    void removeQuestion() {
        Question expected = new Question("Question?", "Answer!");
        Mockito.when(questionRepository.remove(any())).thenReturn(expected);
        Question actual = out.remove(expected);
        assertEquals(expected,actual);
    }

    @Test
    void getRandomQuestion() {
        Question expected = new Question("Question?", "Answer!");
        Collection<Question> expectedList = Set.of(expected);
        Mockito.when(questionRepository.getAll()).thenReturn(expectedList);
        Mockito.when(utilService.getRandomQuestion(expectedList)).thenReturn(expected);
        Question actual = out.getRandomQuestion();
        assertEquals(expected,actual);

    }
}