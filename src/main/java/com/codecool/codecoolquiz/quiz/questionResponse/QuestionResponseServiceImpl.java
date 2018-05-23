package com.codecool.codecoolquiz.quiz.questionResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionResponseServiceImpl implements QuestionResponseService {

    QuestionResponseRepository repository;

    public QuestionResponseServiceImpl(QuestionResponseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<QuestionResponse> findAll() {
        return null;
    }

    @Override
    public QuestionResponse findByQuestionId(Long id) {
        return repository.findByQuestionId(id);
    }

    @Override
    public void sendResponse(QuestionResponse userResponse) {
        repository.save(userResponse);
    }
}
