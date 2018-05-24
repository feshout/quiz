package com.codecool.codecoolquiz.questionResponse;

import java.util.List;

public interface QuestionResponseService {

    QuestionResponse findByQuestionId(Long id);

    QuestionResponse findOneWhereAnswerIsNullAndQuizId(Long quizId);

    void sendResponse(QuestionResponse userResponse);
}
