package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.category.CategoryRepository;
import com.codecool.codecoolquiz.form.QuestionForm;
import com.codecool.codecoolquiz.tag.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void update(QuestionForm questionForm, Long id) {

        Question question = questionRepository.findOne(id);
        question.setTitle(questionForm.getTitle());
        question.setDescription(questionForm.getDescription());
        Category category = categoryRepository.findOne(questionForm.getCategoryId());
        question.setCategory(category);
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
}
