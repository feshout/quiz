package com.codecool.codecoolquiz.answer;

import com.codecool.codecoolquiz.question.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {


}
