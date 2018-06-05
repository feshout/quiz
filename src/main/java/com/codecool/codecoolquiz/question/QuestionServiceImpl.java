package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.answer.Answer;
import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.category.CategoryRepository;
import com.codecool.codecoolquiz.form.QuestionForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private CategoryRepository categoryRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, CategoryRepository categoryRepository) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.getAllByIsActiveTrue();
    }

    @Override
    public Question getById(Long id) {

        return questionRepository.findOne(id);
    }

    @Override
    public Question getByTitle(String title) {
        return questionRepository.getByTitleAndIsActiveTrue(title);
    }

    @Override
    public List<Question> getAllByCategory(Category category) {
        return questionRepository.getAllByCategoryAndIsActiveTrue(category);
    }

    @Override
    public void save(QuestionForm questionForm, Map<String, String> params) {

        Question question = new Question();
        question.setAnswer1(new Answer());
        question.setAnswer2(new Answer());
        question.setAnswer3(new Answer());
        question.setAnswer4(new Answer());
        question.setTitle(questionForm.getTitle());
        question.setDescription(questionForm.getDescription());
        question.setCategory(categoryRepository.findOne(questionForm.getCategoryId()));
        question = handleAnswers(question, questionForm, params);

        questionRepository.save(question);
    }

    @Override
    public void update(QuestionForm questionForm, Long id, Map<String, String> params) {

        Question question = questionRepository.findOne(id);
        Category category = categoryRepository.findOne(questionForm.getCategoryId());

        question.setTitle(questionForm.getTitle());
        question.setDescription(questionForm.getDescription());
        question.setCategory(category);
        question = handleAnswers(question, questionForm, params);

        questionRepository.save(question);

    }
//    Uncomment after implementing tag repository
//    @Override
//    public List<Question> getAllByTag(Tag tag) {
//        return questionRepository.getAllByTagAndIsActiveTrue(tag);
//    }

    @Override
    public void archiveById(Long id) {
        Question question = questionRepository.findOne(id);
        question.setActive(false);
        questionRepository.save(question);
    }

    private Question handleAnswers(Question question, QuestionForm questionForm, Map<String, String> params){

        question.getAnswer1().setDescription(questionForm.getAnswer1());
        question.getAnswer2().setDescription(questionForm.getAnswer2());
        question.getAnswer3().setDescription(questionForm.getAnswer3());
        question.getAnswer4().setDescription(questionForm.getAnswer4());

        if(params.get("isCorrect1") != null) {
            question.getAnswer1().setCorrect(true);
        }
        if(params.get("isCorrect2") != null) {
            question.getAnswer2().setCorrect(true);
        }
        if(params.get("isCorrect3") != null) {
            question.getAnswer3().setCorrect(true);
        }
        if(params.get("isCorrect4") != null) {
            question.getAnswer4().setCorrect(true);
        }

        return question;
    }
}
