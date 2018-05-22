package com.codecool.codecoolquiz.quiz;

import com.codecool.codecoolquiz.category.Category;

import java.util.List;

public interface QuizService {

    Iterable<Category> findCategories();

    void createQuiz(List<Category> categories, int count);


}
