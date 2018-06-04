package com.codecool.codecoolquiz;


import com.codecool.codecoolquiz.answer.Answer;
import com.codecool.codecoolquiz.answer.AnswerRepository;
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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class CodecoolQuizApplication {

	public static void main(String[] args) {

		SpringApplication.run(CodecoolQuizApplication.class, args);
	}







}
