package com.codecool.codecoolquiz.questionResponse;

import java.util.List;

public interface QuestionResponseService {

//    Iterable<QuestionResponse> findAll();
//
//    QuestionResponse findByQuestionId(Long id);
//
    List<QuestionResponse> findByQuizId(Long quizId);

    List<QuestionResponse> findResponseWhereAnswerIsNullAndQuizId(Long quizId);

    void sendResponse(QuestionResponse userResponse);
}
