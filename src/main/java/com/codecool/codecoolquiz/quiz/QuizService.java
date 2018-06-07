package com.codecool.codecoolquiz.quiz;

import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.questionResponse.QuestionResponse;


import java.util.List;

public interface QuizService {

    Iterable<Category> findCategories();

    Quiz createQuiz(List<Category> categories, int count);


}
