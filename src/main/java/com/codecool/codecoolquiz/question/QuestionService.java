package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.form.QuestionForm;
import com.codecool.codecoolquiz.tag.Tag;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    List<Question> getAll();

    Question getById(Long id);

    Question getByTitle(String title);

    List<Question> getAllByCategory(Category category);

    void save(QuestionForm questionForm, Map<String, String> params);

    void update(QuestionForm questionForm, Long id, Map<String, String> params);

//    Uncomment after implementing tag repository
//    List<Question> getAllByTag(Tag tag);

    void archiveById(Long id);
}

