package com.codecool.codecoolquiz.questionResponse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface QuestionResponseRepository  extends CrudRepository<QuestionResponse, Long> {

    QuestionResponse findByQuestionId(Long id);

    List<QuestionResponse> findByQuizId(Long quizId);

    @Query("SELECT response FROM QuestionResponse response WHERE response.answer IS NULL AND response.quiz.id = :quizId")
    List<QuestionResponse> findResponseWhereAnswerIsNullAndQuizId(@Param("quizId") Long quizId);
}
