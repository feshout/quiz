package com.codecool.codecoolquiz.quiz;


import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.question.Question;
import com.codecool.codecoolquiz.questionResponse.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

    private QuizServiceImpl service;

    @Autowired
    public QuizController(QuizServiceImpl service) {
        this.service = service;
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

    @GetMapping("/{quizId}/question/{questionNumber}")
    public Question getQuestion() {

        return null;
    }

    @PostMapping("/{quizId}/question/{questionNumber}")
    public void sendResponse(@RequestBody QuestionResponse userResponse) {

        service.sendResponse(userResponse);
    }
}
































