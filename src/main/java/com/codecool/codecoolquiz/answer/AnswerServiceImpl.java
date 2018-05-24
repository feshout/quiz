package com.codecool.codecoolquiz.answer;

import com.codecool.codecoolquiz.question.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{

    private AnswerRepository answerRepository;

    AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAllByQuestion(Question question) {
        return answerRepository.getAllByQuestion(question);
    }
}
