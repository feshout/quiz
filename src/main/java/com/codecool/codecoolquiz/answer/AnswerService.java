package com.codecool.codecoolquiz.answer;

import com.codecool.codecoolquiz.question.Question;

import java.util.List;


public interface AnswerService {

    List<Answer> getAllByQuestion(Question question);
}
