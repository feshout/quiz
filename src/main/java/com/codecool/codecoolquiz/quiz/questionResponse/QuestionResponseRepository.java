package com.codecool.codecoolquiz.quiz.questionResponse;

import org.springframework.data.repository.CrudRepository;

public interface QuestionResponseRepository  extends CrudRepository<QuestionResponse, Long> {
    QuestionResponse findByQuestionId(Long id);
}
