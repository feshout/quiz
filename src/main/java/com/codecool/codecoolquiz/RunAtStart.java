package com.codecool.codecoolquiz;

import com.codecool.codecoolquiz.answer.Answer;
import com.codecool.codecoolquiz.answer.AnswerRepository;
import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.category.CategoryRepository;
import com.codecool.codecoolquiz.question.Question;
import com.codecool.codecoolquiz.question.QuestionRepository;
import com.codecool.codecoolquiz.questionResponse.QuestionResponse;
import com.codecool.codecoolquiz.questionResponse.QuestionResponseRepository;
import com.codecool.codecoolquiz.quiz.Quiz;
import com.codecool.codecoolquiz.quiz.QuizRepository;
import com.codecool.codecoolquiz.user.User;
import com.codecool.codecoolquiz.user.UserAccess;
import com.codecool.codecoolquiz.user.UserAccessRepository;
import com.codecool.codecoolquiz.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Component
public class RunAtStart {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final UserAccessRepository userAccessRepository;
    private final QuestionResponseRepository questionResponseRepository;
    private final QuizRepository quizRepository;
    private final AnswerRepository answerRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public RunAtStart(UserRepository userRepository, QuestionRepository questionRepository, UserAccessRepository userAccessRepository, QuestionResponseRepository questionResponseRepository, QuizRepository quizRepository, AnswerRepository answerRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.userAccessRepository = userAccessRepository;
        this.questionResponseRepository = questionResponseRepository;
        this.quizRepository = quizRepository;
        this.answerRepository = answerRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void runAtStart() {

        UserAccess adminAccess = new UserAccess("admin");
        UserAccess userAccess = new UserAccess("user");
        userAccessRepository.save(Arrays.asList(adminAccess, userAccess));

        User admin = new User("A", Timestamp.valueOf(LocalDateTime.now()), "admin", "admin", true, adminAccess);
        User user = new User("U", Timestamp.valueOf(LocalDateTime.now()), "user", "user", true, userAccess);
        userRepository.save(Arrays.asList(admin, user));

        Quiz quiz = new Quiz(new Date(), user);

        Question question1 = new Question("Testowe1", "Opis1", true);

        Answer answer1 = new Answer("Pierwsza odpowiedź", true);
        Answer answer2 = new Answer("Druga odpowiedź", false);
        Answer answer3 = new Answer("Trzecia odpowiedź", false);
        Answer answer4 = new Answer("Czwarta odpowiedź", false);

        question1.setAnswer1(answer1);
        question1.setAnswer2(answer2);
        question1.setAnswer3(answer3);
        question1.setAnswer4(answer4);

        QuestionResponse questionResponse1 = new QuestionResponse(quiz, question1, answer1.getDescription());


        quizRepository.save(quiz);

        Category category1 = new Category("SQL", true, user, new Date(), user, new Date());
        Category category2 = new Category("OOP", true, user, new Date(), user, new Date());

        categoryRepository.save(category1);
        categoryRepository.save(category2);


        question1.setCategory(category1);
        questionRepository.save(question1);

        questionResponseRepository.save(questionResponse1);


    }
}
