package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.answer.AnswerService;
import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.category.CategoryService;
import com.codecool.codecoolquiz.form.QuestionForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping(path = "/questions")
public class QuestionController{

    private QuestionService questionService;
    private AnswerService answerService;
    private CategoryService categoryService;

    QuestionController(QuestionService questionService, AnswerService answerService, CategoryService categoryService){

        this.questionService = questionService;
        this.answerService = answerService;
        this.categoryService = categoryService;
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public String getAll(Model model) {

        model.addAttribute("questions", questionService.getAll());
        return "question/questions";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getQuestionById(@PathVariable Long id, Model model) {
        Question question = questionService.getById(id);
        model.addAttribute("question", question);
        model.addAttribute("answers", answerService.getAllByQuestion(question));
        return "question/question";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String getQuestionForm(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "question/questionForm";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("questionForm") QuestionForm questionForm, @RequestParam Map<String, String> params, Model model){

        questionService.save(questionForm, params);
        Question newQuestion = questionService.getByTitle(questionForm.getTitle());
        model.addAttribute("question", newQuestion);

        return "question/question";
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String getQuestionFormToEdit(@PathVariable Long id, Model model){

        Question question = questionService.getById(id);
        model.addAttribute("question", question);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("answers", answerService.getAllByQuestion(question));
        return "question/questionForm";
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public String updateQuestion(@PathVariable Long id, @ModelAttribute("questionForm") QuestionForm questionForm, Model model, @RequestParam Map<String, String> params){
        questionService.update(questionForm, id, params);
        model.addAttribute("question", questionService.getById(id));

        return "question/question";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String archiveQuestion(@PathVariable Long id) {
        questionService.archiveById(id);
        return "redirect:question/questions";
    }







}
