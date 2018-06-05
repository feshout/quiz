package com.codecool.codecoolquiz.quiz;


import com.codecool.codecoolquiz.category.Category;

import com.codecool.codecoolquiz.questionResponse.QuestionResponse;
import com.codecool.codecoolquiz.questionResponse.QuestionResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

    private QuizServiceImpl service;
    private QuestionResponseServiceImpl responseService;

    @Autowired
    public QuizController(QuizServiceImpl service, QuestionResponseServiceImpl responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @GetMapping("/")
    public Iterable<Category> displayCategories(){
        return service.findCategories();
    }

    @PostMapping("/")
    public Quiz chosenCategory(@RequestBody List<Category> categories, @RequestBody int count){

        Quiz quiz = service.createQuiz(categories, count);

        return quiz;
    }

    @GetMapping("/{quizId}/question/{id}")
    public QuestionResponse getQuestion(@PathVariable("id") Long id) {

        QuestionResponse response = responseService.findByQuestionId(id);

        return response;
    }

    @PostMapping("/{quizId}/question/{id}")
    public void sendResponse(@RequestBody QuestionResponse response) {

        responseService.sendResponse(response);
    }

    @GetMapping("/{quizId}/question")
    public List<QuestionResponse> getQuestions(@PathVariable Long quizId) {

        return responseService.findByQuizId(quizId);
    }

    @GetMapping("/{quizId}/results")
    public List<QuestionResponse> getResults(@PathVariable Long quizId) {

        return responseService.findByQuizId(quizId);
    }


}
































