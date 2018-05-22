package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.tag.Tag;

import java.util.List;

public interface QuestionService {

    List<Question> getAll();

    Question getById(Long id);

    List<Question> getAllByCategory(Category category);

    void saveOrUpdate(Question question);

    List<Question> getAllByTag(Tag tag);

    void archiveById(Long id);
}

