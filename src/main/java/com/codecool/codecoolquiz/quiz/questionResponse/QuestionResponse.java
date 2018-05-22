package com.codecool.codecoolquiz.quiz.questionResponse;

import com.codecool.codecoolquiz.question.Question;
import com.codecool.codecoolquiz.quiz.Quiz;

import javax.persistence.*;

@Entity
public class QuestionResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Quiz quiz;
    @ManyToOne
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
