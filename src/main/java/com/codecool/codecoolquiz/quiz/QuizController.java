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
    public List<Category> chosenCategory(@RequestBody List<Category> categories, @RequestBody int count){

        service.createQuiz(categories, count);

        return null;
    }

    @GetMapping("/{quizId}/question/{id}")
    public QuestionResponse getQuestion(@PathVariable Long id, @PathVariable Long quizId) {

        return responseService.findByQuestionId(id);
    }

    @PostMapping("/{quizId}/question/{id}")
    public void sendResponse(@RequestBody QuestionResponse response,
                             @PathVariable Long id,
                             @PathVariable Long quizId) {

        responseService.sendResponse(response);
    }
}
































