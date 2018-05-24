package com.codecool.codecoolquiz;


import com.codecool.codecoolquiz.question.QuestionRepository;
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


	@Bean
	public CommandLineRunner demo(UserRepository userRepository,
								  QuestionRepository questionRepository,
								  UserAccessRepository userAccessRepository) {
		return (args) -> {

			UserAccess access = new UserAccess("admin");
			userAccessRepository.save(access);

//			User user = new User("test", new Date(), "login", "1234", )

		};
	}

}
