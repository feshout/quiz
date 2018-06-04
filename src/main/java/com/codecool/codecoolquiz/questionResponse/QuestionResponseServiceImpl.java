package com.codecool.codecoolquiz.questionResponse;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionResponseServiceImpl implements QuestionResponseService {

    QuestionResponseRepository repository;

    public QuestionResponseServiceImpl(QuestionResponseRepository repository) {
        this.repository = repository;
    }


    @Override
    public QuestionResponse findOneWhereAnswerIsNullAndQuizId(Long quizId) {

        List<QuestionResponse> questionResponse = (List<QuestionResponse>) repository.findAllWhereAnswerIsNullAndQuizId(quizId);

        return questionResponse.get(0);
    }

//    @Override
//    public Iterable<QuestionResponse> findAll() {
//        return repository.findAll();
//    }

//    @Override
//    public QuestionResponse findByQuestionId(Long id) {
//        return repository.findByQuestionId(id);
//    }

    @Override
    public List<QuestionResponse> findByQuizId(Long quizId) {

        return repository.findByQuizId(quizId);
    }

    @Override
    public void sendResponse(QuestionResponse userResponse) {

        repository.save(userResponse);
    }
}
