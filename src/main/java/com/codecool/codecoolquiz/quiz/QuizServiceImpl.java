package com.codecool.codecoolquiz.quiz;

import com.codecool.codecoolquiz.answer.AnswerRepository;
import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.category.CategoryRepository;
import com.codecool.codecoolquiz.question.Question;
import com.codecool.codecoolquiz.question.QuestionRepository;
import com.codecool.codecoolquiz.questionResponse.QuestionResponse;
import com.codecool.codecoolquiz.questionResponse.QuestionResponseRepository;
import com.codecool.codecoolquiz.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private CategoryRepository categoryRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private UserRepository userRepository;
    private QuestionResponseRepository responseRepository;

    public QuizServiceImpl(CategoryRepository categoryRepository,
                           QuestionRepository questionRepository,
                           AnswerRepository answerRepository,
                           UserRepository userRepository,
                           QuestionResponseRepository responseRepository) {
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.responseRepository = responseRepository;
    }

    @Override
    public Iterable<Category> findCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createQuiz(List<Category> categories, int count) {

        List<Question> questions = getQuestions(categories);
        List<Question> randomQuestions = getRandomQuestions(questions, count);

        Quiz quiz = new Quiz(new Date(), userRepository.findOne(1L));
        createResponses(quiz, randomQuestions);

    }

    @Override
    public void sendResponse(QuestionResponse userResponse) {

    }

    private List<Question> getRandomQuestions(List<Question> questions, int count) {

        List<Question> copy = new ArrayList<>(questions);
        Collections.shuffle(copy);
        return copy.subList(0, count);
    }

    private List<Question> getQuestions(List<Category> categories) {

        List<Long> categoryId = categories.stream().map(Category::getId).collect(Collectors.toList());

        return questionRepository.findByCategory(categoryId);
    }

    private void createResponses(Quiz quiz, List<Question> questions){

        for (Question question : questions) {
            responseRepository.save(new QuestionResponse(quiz, question, null));
        }
    }
}
