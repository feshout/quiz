package com.codecool.codecoolquiz.quiz.questionResponse;

import java.util.List;

public interface QuestionResponseService {

    List<QuestionResponse> findAll();
    QuestionResponse findByQuestionId(Long id);

    void sendResponse(QuestionResponse userResponse);
}
