package com.codecool.codecoolquiz.questionResponse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionResponseRepository  extends CrudRepository<QuestionResponse, Long> {

    QuestionResponse findByQuestionId(Long id);

    @Query("SELECT response FROM QuestionResponse response WHERE response.answer IS NULL AND response.quiz.id = :quizId")
    Iterable<QuestionResponse> findAllWhereAnswerIsNullAndQuizId(@Param("quizId") Long quizId);
}
